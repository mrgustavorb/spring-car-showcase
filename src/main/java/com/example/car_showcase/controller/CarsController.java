package com.example.car_showcase.controller;

import com.example.car_showcase.model.Car;
import com.example.car_showcase.model.Manufacturer;
import com.example.car_showcase.request.CarRequest;
import com.example.car_showcase.service.CarService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cars")
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        return ResponseEntity.status(HttpStatus.OK).body(carService.listCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.getCarById(id));
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody CarRequest carRequest) {
        Optional<Manufacturer> manufacturer = carService.getManufacturerById(carRequest.getManufacturerId());

        if (manufacturer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Return 400 if manufacturer is not found
        }

        Car car = new Car();
        car.setManufacturer(manufacturer.get());
        car.setName(carRequest.getName());
        car.setYear(carRequest.getYear());

        return ResponseEntity.status(HttpStatus.CREATED).body(carService.createCar(car));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @NotNull @RequestBody Car car) {
        car.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(carService.updateCar(car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
