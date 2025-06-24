package com.locationcar.backend.service.Impl;


import com.locationcar.backend.entity.Client;
import com.locationcar.backend.repository.ClientRepository;
import com.locationcar.backend.service.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + id));
    }

    @Override
    public Client updateClient(Long id, Client updatedClient) {
        Client existing = getClientById(id);
        existing.setFirstName(updatedClient.getFirstName());
        existing.setLastName(updatedClient.getLastName());
        existing.setEmail(updatedClient.getEmail());
        existing.setPhone(updatedClient.getPhone());
        existing.setAddress(updatedClient.getAddress());
        return clientRepository.save(existing);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
