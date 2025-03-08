package com.example.car_showcase.controller;

import com.example.car_showcase.model.Manufacturer;
import com.example.car_showcase.service.ManufacturerService;
import jakarta.validation.constraints.NotNull;
import org.apache.coyote.Response;
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
    public ResponseEntity<List<Manufacturer>> listManufacturers() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(manufacturerService.listManufacturers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Manufacturer>> getManufacturerById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(manufacturerService.getManufacturerById(id));
    }

    @PostMapping
    public ResponseEntity<Manufacturer> createManufacturer(@NotNull @RequestBody Manufacturer manufacturer) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(manufacturerService.createManufacturer(manufacturer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manufacturer> updateManufacturer(@PathVariable Long id, @NotNull @RequestBody Manufacturer manufacturer) {
        manufacturer.setId(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(manufacturerService.updateManufacturer(manufacturer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManufacturer(@PathVariable Long id) {
        manufacturerService.deleteManufacturer(id);
        return ResponseEntity.noContent().build();
    }
}
