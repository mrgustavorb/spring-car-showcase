package com.example.car_showcase.service;

import com.example.car_showcase.model.Car;
import com.example.car_showcase.model.Manufacturer;
import com.example.car_showcase.repository.ManufacturerRepository;
import com.example.car_showcase.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public List<Manufacturer> listManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Optional<Manufacturer> getManufacturerById(Long id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fabricante não encontrado"));

        return Optional.ofNullable(manufacturer);
    }

    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public void deleteManufacturer(Long id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fabricante não encontrado"));

        manufacturerRepository.delete(manufacturer);
    }

    public Optional<Manufacturer> getManufacturerAndCarsById(Long id) {
        return manufacturerRepository.findByIdWithCars(id);
    }
}
