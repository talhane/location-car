package com.locationcar.backend.service.service;



import com.locationcar.backend.entity.Client;

import java.util.List;

public interface ClientService {
    Client createClient(Client client);
    List<Client> getAllClients();
    Client getClientById(Long id);
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
}