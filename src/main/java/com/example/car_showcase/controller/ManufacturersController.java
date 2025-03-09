package com.example.car_showcase.controller;

import com.example.car_showcase.model.Manufacturer;
import com.example.car_showcase.response.ManufacturerCarsResponse;
import com.example.car_showcase.response.ManufacturerResponse;
import com.example.car_showcase.service.ManufacturerService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/manufacturers")
public class ManufacturersController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public ResponseEntity<List<ManufacturerResponse>> listManufacturers() {
        List<Manufacturer> manufacturers = manufacturerService.listManufacturers();

        List<ManufacturerResponse> response = manufacturers.stream()
                .map(this::buildResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturerResponse> getManufacturerById(@PathVariable Long id) {
        Optional<Manufacturer> manufacturer = manufacturerService.getManufacturerById(id);

        if (manufacturer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ManufacturerResponse response = buildResponse(manufacturer.orElse(null));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ManufacturerResponse> createManufacturer(@NotNull @RequestBody Manufacturer manufacturer) {
        Manufacturer newManufacturer = manufacturerService.createManufacturer(manufacturer);

        ManufacturerResponse response = buildResponse(newManufacturer);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufacturerResponse> updateManufacturer(@PathVariable Long id, @NotNull @RequestBody Manufacturer manufacturer) {
        Optional<Manufacturer> existingManufacturer = manufacturerService.getManufacturerById(id);

        if (existingManufacturer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        manufacturer.setCreatedAt(existingManufacturer.get().getCreatedAt());
        manufacturer.setId(id);

        manufacturerService.updateManufacturer(manufacturer);

        ManufacturerResponse response = buildResponse(existingManufacturer.orElse(null));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManufacturer(@PathVariable Long id) {
        manufacturerService.deleteManufacturer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/cars")
    public ResponseEntity<ManufacturerCarsResponse> listCarsByManufacturerId(@PathVariable Long id) {
        Optional<Manufacturer> manufacturer = manufacturerService.getManufacturerById(id);

        if (manufacturer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        ManufacturerCarsResponse response = buildManufacturerCarsResponse(manufacturer.orElse(null));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    private ManufacturerResponse buildResponse(Manufacturer manufacturer) {
        return new ManufacturerResponse(
                manufacturer.getId(),
                manufacturer.getYear(),
                manufacturer.getName(),
                manufacturer.getCountry(),
                manufacturer.getCreatedAt(),
                manufacturer.getUpdatedAt()
        );
    }

    private ManufacturerCarsResponse buildManufacturerCarsResponse(Manufacturer manufacturer) {
        return new ManufacturerCarsResponse(
                manufacturer.getId(),
                manufacturer.getYear(),
                manufacturer.getName(),
                manufacturer.getCountry(),
                manufacturer.getCreatedAt(),
                manufacturer.getUpdatedAt(),
                manufacturer.getCars()
        );
    }
}
