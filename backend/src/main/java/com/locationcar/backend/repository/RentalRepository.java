package com.locationcar.backend.repository;

import com.locationcar.backend.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}