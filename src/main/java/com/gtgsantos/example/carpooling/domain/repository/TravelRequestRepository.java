package com.gtgsantos.example.carpooling.domain.repository;

import com.gtgsantos.example.carpooling.domain.entity.TravelRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRequestRepository extends JpaRepository<TravelRequest, Long> {
}
