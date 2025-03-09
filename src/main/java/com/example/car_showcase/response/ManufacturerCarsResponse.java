package com.example.car_showcase.response;

import com.example.car_showcase.model.Car;

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
        super(id, year, name, country, createdAt, updatedAt);
        this.cars = cars;
    }

    // Getter for cars
    public List<Car> getCars() {
        return cars;
    }
}
