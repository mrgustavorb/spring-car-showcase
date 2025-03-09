package com.example.car_showcase.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManufacturerTests {

    @Test
    public void shouldCreateManufacturer() {
        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setName("Example name");
        manufacturer.setCountry("Example country");
        manufacturer.setYear(1997);

        assertThat(manufacturer.getName()).isEqualTo("Example name");
        assertThat(manufacturer.getCountry()).isEqualTo("Example country");
        assertThat(manufacturer.getYear()).isEqualTo(1997);
    }

    @Test
    public void shouldAddCars() {
        Manufacturer manufacturer = new Manufacturer();
        Car car = new Car();
        car.setName("Example car name");

        manufacturer.getCars().add(car);
        assertThat(manufacturer.getCars()).hasSize(1);
        assertThat(manufacturer.getCars().get(0).getName()).isEqualTo("Example car name");
    }
}
