package com.gtgsantos.example.carpooling.domain.repository;

import com.gtgsantos.example.carpooling.domain.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {

}
