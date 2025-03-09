package com.example.car_showcase.response;

import com.example.car_showcase.model.Car;
import com.example.car_showcase.model.Manufacturer;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public class ManufacturerCarsResponse extends ManufacturerResponse {
    private List<Car> cars;

    public ManufacturerCarsResponse(
            Long id,
            Integer year,
            String name,
            String country,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            List<Car> cars
    ) {
        super();
        this.cars = cars;
    }
}
