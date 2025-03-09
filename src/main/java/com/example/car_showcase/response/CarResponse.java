package com.example.car_showcase.response;

import java.time.LocalDateTime;

public class CarResponse {
    public Long id;
    public String name;
    public Integer year;
    public Long manufacturerId;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public CarResponse(
            Long id,
            String name,
            Integer year,
            Long manufacturerId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.manufacturerId = manufacturerId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
