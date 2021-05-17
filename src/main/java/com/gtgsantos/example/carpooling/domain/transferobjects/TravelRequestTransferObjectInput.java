package com.gtgsantos.example.carpooling.domain.transferobjects;

import com.gtgsantos.example.carpooling.domain.enums.TravelRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TravelRequestTransferObjectInput {

    private Long passengerId;
    private String origin;
    private String destination;
    private TravelRequestStatus status;
}
