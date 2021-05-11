package com.gtgsantos.example.carpooling.rest;

import com.gtgsantos.example.carpooling.domain.entity.TravelRequest;
import com.gtgsantos.example.carpooling.domain.mapping.TravelRequestMapper;
import com.gtgsantos.example.carpooling.domain.service.TravelRequestService;
import com.gtgsantos.example.carpooling.domain.transferobjects.TravelRequestTransferObjectInput;
import com.gtgsantos.example.carpooling.domain.transferobjects.TravelRequestTransferObjectOutput;
import com.gtgsantos.example.carpooling.rest.interfaces.TravelRequestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/travelRequests", produces = MediaType.APPLICATION_JSON_VALUE)
public class TravelRequestRest implements TravelRequestAPI {

    @Autowired
    private TravelRequestService travelRequestService;

    @Autowired
    private TravelRequestMapper mapper;


    @GetMapping("/nearby")
    public List<TravelRequestTransferObjectOutput> findTravelRequest(@RequestParam String currentAddress) {
        List<TravelRequest> listaNearbyTravels = travelRequestService.listNearbyTravelRequests(currentAddress);
        return mapper.mapTo(listaNearbyTravels);
    }

    @PostMapping
    public TravelRequestTransferObjectOutput makeTravelRequest(@RequestBody @Valid TravelRequestTransferObjectInput travelRequestTransferObjectInput) {
        TravelRequest newTravelRequest = travelRequestService.save(mapper.mapTo(travelRequestTransferObjectInput));
        TravelRequestTransferObjectOutput output = mapper.mapTo(newTravelRequest);
        return output;
    }

}
