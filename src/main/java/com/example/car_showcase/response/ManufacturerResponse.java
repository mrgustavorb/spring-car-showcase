package com.example.car_showcase.response;

import java.time.LocalDateTime;

public class ManufacturerResponse {
    private Long id;
    private Integer year;
    private String name;
    private String country;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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

    // Getters
    public Long getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
