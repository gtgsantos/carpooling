package com.gtgsantos.example.carpooling.domain.transferobjects;

import com.gtgsantos.example.carpooling.domain.enums.TravelRequestStatus;
import lombok.Value;

@Value
public class TravelRequestTransferObjectOutput {

    Long passengerID;
    String origin;
    String destination;
    TravelRequestStatus status;
}
