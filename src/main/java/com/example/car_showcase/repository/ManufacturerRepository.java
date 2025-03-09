package com.example.car_showcase.repository;

import com.example.car_showcase.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    @Query("SELECT m FROM Manufacturer m LEFT JOIN FETCH m.cars c WHERE m.id = :id ORDER BY c.id DESC")
    Optional<Manufacturer> findByIdWithCars(@Param("id") Long id);
}
