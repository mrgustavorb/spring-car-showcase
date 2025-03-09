package com.example.car_showcase.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "manufacturers")
public class Manufacturer extends BaseEntity {

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private List<Car> cars;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private Integer year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Car> getCars() {
        return cars;
    }
 }
