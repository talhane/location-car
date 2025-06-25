package com.locationcar.backend.repository;


import com.locationcar.backend.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByRegistrationNumber(String registrationNumber);
}
