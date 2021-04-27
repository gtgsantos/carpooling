package com.gtgsantos.example.carpooling.domain.repository;

import com.gtgsantos.example.carpooling.domain.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
