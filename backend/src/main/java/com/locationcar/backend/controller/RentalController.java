package com.locationcar.backend.controller;


import com.locationcar.backend.entity.Rental;
import com.locationcar.backend.service.service.RentalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RentalController {

    private final RentalService rentalService;

    @PostMapping
    public ResponseEntity<Rental> createRental(@Valid @RequestBody Rental rental) {
        return ResponseEntity.ok(rentalService.createRental(rental));
    }

    @GetMapping
    public ResponseEntity<List<Rental>> getAllRentals() {
        return ResponseEntity.ok(rentalService.getAllRentals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRentalById(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getRentalById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rental> updateRental(@PathVariable Long id, @Valid @RequestBody Rental rental) {
        return ResponseEntity.ok(rentalService.updateRental(id, rental));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
        return ResponseEntity.noContent().build();
    }
}

