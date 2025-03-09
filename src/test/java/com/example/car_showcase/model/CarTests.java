package com.example.car_showcase.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTests {

    @Test
    public void shouldCreateCar() {
        Car car = new Car();

        car.setName("Example car");
        car.setYear(1997);

        assertThat(car.getName()).isEqualTo("Example car");
        assertThat(car.getYear()).isEqualTo(1997);

    }

    @Test
    public void shouldAssociateManufacturer() {
        Car car = new Car();

        Long id = Long.valueOf(1);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(id);

        car.setManufacturer(manufacturer);

        assertThat(car.getManufacturerId()).isEqualTo(id);
    }
}
