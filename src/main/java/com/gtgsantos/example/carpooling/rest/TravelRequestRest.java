package com.gtgsantos.example.carpooling.rest;

import com.gtgsantos.example.carpooling.domain.entity.TravelRequest;
import com.gtgsantos.example.carpooling.domain.service.TravelRequestService;
import com.gtgsantos.example.carpooling.rest.interfaces.TravelRequestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/travelRequests", produces = MediaType.APPLICATION_JSON_VALUE)
public class TravelRequestRest implements TravelRequestAPI {

    @Autowired
    private TravelRequestService travelRequestService;

    @GetMapping("/{id}")
    public TravelRequest findTravelRequest(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping
    public void createTravelRequest(@RequestBody TravelRequest travelRequest) {
        travelRequestService.create(travelRequest);
    }
}
