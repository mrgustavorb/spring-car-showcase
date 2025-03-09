package com.example.car_showcase.response;

import com.example.car_showcase.model.Manufacturer;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ManufacturerResponse {
    public Long id;
    public Integer year;
    public String name;
    public String country;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public ManufacturerResponse(
            Long id,
            Integer year,
            String name,
            String country,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.country = country;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ManufacturerResponse() {
    }

    public ManufacturerResponse(@NotNull Manufacturer manufacturer) {
    }
}
