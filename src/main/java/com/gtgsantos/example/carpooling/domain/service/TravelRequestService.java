package com.gtgsantos.example.carpooling.domain.service;

import com.gtgsantos.example.carpooling.domain.entity.TravelRequest;
import com.gtgsantos.example.carpooling.domain.enums.TravelRequestStatus;
import com.gtgsantos.example.carpooling.domain.repository.TravelRequestRepository;
import com.gtgsantos.example.carpooling.domain.service.output.GMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelRequestService {

    @Autowired
    private TravelRequestRepository travelRequestRepository;

    @Autowired
    private GMapsService gMapsService;

    private static final int MAX_TRAVEL_TIME = 600;

    public List<TravelRequest> listNearbyTravelRequests(String currentAddress) {
        List<TravelRequest> requests = travelRequestRepository.findByStatus(TravelRequestStatus.CREATED);
        return requests
                .stream()
                .filter(tr -> gMapsService.getDistanceBetweenAddresses(currentAddress, tr.getOrigin()) < MAX_TRAVEL_TIME)
                .collect(Collectors.toList());
    }

    public TravelRequest save(TravelRequest travelRequest) {
        travelRequest.setStatus(TravelRequestStatus.CREATED);
        travelRequest.setCreationDate(new Date());
        return travelRequestRepository.save(travelRequest);
    }

}
