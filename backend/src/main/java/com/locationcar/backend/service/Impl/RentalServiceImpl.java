package com.locationcar.backend.service.Impl;


import com.locationcar.backend.entity.Rental;
import com.locationcar.backend.repository.RentalRepository;
import com.locationcar.backend.service.service.RentalService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private  RentalRepository rentalRepository;

    @Override
    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rental not found with ID: " + id));
    }

    @Override
    public Rental updateRental(Long id, Rental updatedRental) {
        Rental existing = getRentalById(id);
        existing.setCar(updatedRental.getCar());
        existing.setClient(updatedRental.getClient());
        existing.setStartDate(updatedRental.getStartDate());
        existing.setEndDate(updatedRental.getEndDate());
        existing.setTotalPrice(updatedRental.getTotalPrice());
        return rentalRepository.save(existing);
    }

    @Override
    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}
