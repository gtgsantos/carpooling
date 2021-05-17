package com.gtgsantos.example.carpooling.domain.mapping;

import com.gtgsantos.example.carpooling.domain.entity.Passenger;
import com.gtgsantos.example.carpooling.domain.entity.TravelRequest;
import com.gtgsantos.example.carpooling.domain.enums.TravelRequestStatus;
import com.gtgsantos.example.carpooling.domain.repository.PassengerRepository;
import com.gtgsantos.example.carpooling.domain.transferobjects.TravelRequestTransferObjectInput;
import com.gtgsantos.example.carpooling.domain.transferobjects.TravelRequestTransferObjectOutput;
import com.gtgsantos.example.carpooling.rest.PassengerRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelRequestMapper {

    @Autowired
    PassengerRepository passengerRepository;

    public  TravelRequestTransferObjectOutput mapTo(TravelRequest travelRequest) {
        return new TravelRequestTransferObjectOutput(travelRequest.getId(), travelRequest.getOrigin(),
                travelRequest.getDestination(), travelRequest.getStatus(), travelRequest.getCreationDate());
    }

    public EntityModel<TravelRequestTransferObjectOutput> buildOutputModel(TravelRequest  travelRequest) {

        EntityModel<TravelRequestTransferObjectOutput> model = EntityModel.of(mapTo(travelRequest));

        Link passengerLink = WebMvcLinkBuilder
                .linkTo(PassengerRest.class)
                .slash(travelRequest.getPassenger().getId())
                .withRel("passenger")
                .withTitle(travelRequest.getPassenger().getName());
        model.add(passengerLink);

        return model;
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
                        .getPassengerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return TravelRequest.builder()
                .passenger(passenger)
                .origin(travelRequestTransferObjectInput.getOrigin())
                .destination(travelRequestTransferObjectInput.getDestination())
                .build();
    }
}
