package com.locationcar.backend.service;


import com.locationcar.backend.entity.Car;
import com.locationcar.backend.entity.CarStatus;
import com.locationcar.backend.repository.CarRepository;
import com.locationcar.backend.service.Impl.CarServiceImpl;
import com.locationcar.backend.service.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(CarServiceImpl.class)
class CarServiceTest {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository.deleteAll();          // i clean table before every test
    }

    @Test
    void createCar_shouldPersistAndReturnWithId() {
        Car created = carService.createCar(
                Car.builder()
                        .brand("Tesla")
                        .model("Model 3")
                        .registrationNumber("TES-123")
                        .status(CarStatus.AVAILABLE)
                        .pricePerDay(99.0)
                        .build());

        assertThat(created.getId()).isNotNull();
        assertThat(carRepository.count()).isEqualTo(1);
    }

    @Test
    void getAllCars_shouldReturnSavedCars() {
        carRepository.save(
                Car.builder()
                        .brand("Renault").model("Clio")
                        .registrationNumber("CL-456")
                        .status(CarStatus.AVAILABLE)
                        .pricePerDay(40.0)
                        .build());

        List<Car> cars = carService.getAllCars();

        assertThat(cars).hasSize(1);
        assertThat(cars.get(0).getBrand()).isEqualTo("Renault");
    }
}
