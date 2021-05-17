package com.gtgsantos.example.carpooling.domain.transferobjects;

import com.gtgsantos.example.carpooling.domain.enums.TravelRequestStatus;
import lombok.Value;

import java.util.Date;

@Value
public class TravelRequestTransferObjectOutput {

    Long id;
    String origin;
    String destination;
    TravelRequestStatus status;
    Date creationDate;
}
