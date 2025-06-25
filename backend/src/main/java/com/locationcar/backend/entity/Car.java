package com.locationcar.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @Column(unique = true)
    @NotBlank
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    @NotNull
    private CarStatus status;

    @NotNull
    private Double pricePerDay;
}
