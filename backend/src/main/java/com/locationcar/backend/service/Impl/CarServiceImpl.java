package com.locationcar.backend.service.Impl;

import com.locationcar.backend.entity.Car;
import com.locationcar.backend.repository.CarRepository;
import com.locationcar.backend.service.service.CarService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    @Autowired
    private  CarRepository carRepository;

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car not found with ID: " + id));
    }

    @Override
    public Car updateCar(Long id, Car updatedCar) {
        Car existingCar = getCarById(id);
        existingCar.setBrand(updatedCar.getBrand());
        existingCar.setModel(updatedCar.getModel());
        existingCar.setPricePerDay(updatedCar.getPricePerDay());
        existingCar.setStatus(updatedCar.getStatus());
        existingCar.setRegistrationNumber(updatedCar.getRegistrationNumber());
        return carRepository.save(existingCar);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
