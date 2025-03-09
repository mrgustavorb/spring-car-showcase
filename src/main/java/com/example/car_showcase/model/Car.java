package com.example.car_showcase.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    @OrderBy("created_at DESC")
    @JsonBackReference
    private Manufacturer manufacturer;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer year;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getManufacturerId() {
        return this.manufacturer != null ? this.manufacturer.getId() : null;
    }
}
