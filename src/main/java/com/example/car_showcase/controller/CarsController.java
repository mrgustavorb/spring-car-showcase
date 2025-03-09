package com.example.car_showcase.controller;

import com.example.car_showcase.model.Car;
import com.example.car_showcase.model.Manufacturer;
import com.example.car_showcase.request.CarRequest;
import com.example.car_showcase.response.CarResponse;
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
    public ResponseEntity<List<CarResponse>> getCars() {
        List<Car> cars = carService.listCars();

        List<CarResponse> response = cars.stream()
                .map(this::buildResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);

        if(car.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        CarResponse response = buildResponse(car.orElse(null));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<CarResponse> createCar(@RequestBody CarRequest carRequest) {
        Optional<Manufacturer> manufacturer = carService.getManufacturerById(carRequest.getManufacturerId());

        if (manufacturer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Car car = buildCar(carRequest, manufacturer);

        carService.createCar(car);

        CarResponse response = buildResponse(car);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarResponse> updateCar(@PathVariable Long id, @NotNull @RequestBody Car car) {
        Optional<Car> persistedCar = carService.getCarById(id);

        if(persistedCar.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if (car.getManufacturerId() == null) {
            car.setManufacturer(persistedCar.get().getManufacturer());
        }

        car.setId(id);
        car.setCreatedAt(persistedCar.get().getCreatedAt());

        carService.updateCar(car);

        CarResponse response = buildResponse(car);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    public Car buildCar(CarRequest carRequest, Optional<Manufacturer> manufacturer) {
        Car car = new Car();

        if(manufacturer.isEmpty()) {
            return car;
        }

        car.setManufacturer(manufacturer.get());
        car.setName(carRequest.getName());
        car.setYear(carRequest.getYear());

        return car;
    }

    private CarResponse buildResponse(Car car) {
        return new CarResponse(
                car.getId(),
                car.getName(),
                car.getYear(),
                car.getManufacturer().getId(),
                car.getCreatedAt(),
                car.getUpdatedAt()
        );
    }
}
