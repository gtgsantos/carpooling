package com.gtgsantos.example.carpooling.domain.repository;

import com.gtgsantos.example.carpooling.domain.entity.Driver;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

@Tag(name="Driver Api", description = "Handle Passenger's data")
public interface DriverRepository extends JpaRepository<Driver, Long> {


}
