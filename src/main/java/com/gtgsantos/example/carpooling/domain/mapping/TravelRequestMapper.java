package com.gtgsantos.example.carpooling.domain.mapping;

import com.gtgsantos.example.carpooling.domain.entity.Passenger;
import com.gtgsantos.example.carpooling.domain.entity.TravelRequest;
import com.gtgsantos.example.carpooling.domain.repository.PassengerRepository;
import com.gtgsantos.example.carpooling.domain.transferobjects.TravelRequestTransferObjectInput;
import com.gtgsantos.example.carpooling.domain.transferobjects.TravelRequestTransferObjectOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelRequestMapper {

    @Autowired
    PassengerRepository passengerRepository;

    public  TravelRequestTransferObjectOutput mapTo(TravelRequest travelRequest) {
        return new TravelRequestTransferObjectOutput(travelRequest.getPassenger().getId(),
                travelRequest.getOrigin(), travelRequest.getDestination(), travelRequest.getStatus());
    }

    public List<TravelRequestTransferObjectOutput> mapTo(List<TravelRequest> listaNearbyTravels) {
        return listaNearbyTravels
                .stream()
                .map(this::mapTo)
                .collect(Collectors.toList());

    }

    public TravelRequest mapTo(TravelRequestTransferObjectInput travelRequestTransferObjectInput) {
        Passenger passenger = passengerRepository
                .findById(travelRequestTransferObjectInput
                        .getPassengerID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return new TravelRequest(passenger,
                travelRequestTransferObjectInput.getOrigin(),
                travelRequestTransferObjectInput.getDestination(),
                travelRequestTransferObjectInput.getStatus());
    }
}
