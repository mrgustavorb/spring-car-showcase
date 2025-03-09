package com.example.car_showcase.request;

public class CarRequest {
    private String name;
    private Long manufacturerId;
    private Integer year;

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
