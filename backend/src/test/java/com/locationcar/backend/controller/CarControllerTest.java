package com.locationcar.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.locationcar.backend.entity.Car;
import com.locationcar.backend.entity.CarStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createCar_endpointReturns200() throws Exception {
        Car car = Car.builder()
                .brand("Ford")
                .model("Focus")
                .registrationNumber("FO-789")
                .status(CarStatus.AVAILABLE)
                .pricePerDay(55.0)
                .build();

        mockMvc.perform(post("/api/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(car)))
                .andExpect(status().isOk());
    }
}
