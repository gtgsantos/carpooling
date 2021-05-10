package com.gtgsantos.example.carpooling.domain.service;

import com.gtgsantos.example.carpooling.domain.entity.TravelRequest;
import com.gtgsantos.example.carpooling.domain.repository.TravelRequestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class TravelRequestService {

    private TravelRequestRepository repository;

    public void create(TravelRequest travelRequest) {
        repository.save(travelRequest);
    }

    public TravelRequest find(Long id) {
        Optional<TravelRequest> optional = repository.findById(id);
        return optional.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


}
