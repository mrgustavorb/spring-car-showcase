package com.example.car_showcase.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="manufacturer_id")
    private Manufacturer manufacturer;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false, insertable=false, updatable=false)
    private Integer manufacturer_id;

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

    public Integer getManufacturerId(Integer manufacturer_id) {
        return manufacturer_id;
    }

    public void setManufactureId(Integer manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer() {
        this.manufacturer = manufacturer;
    }
}
