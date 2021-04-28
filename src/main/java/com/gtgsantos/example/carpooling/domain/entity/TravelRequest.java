package com.gtgsantos.example.carpooling.domain.entity;

import com.gtgsantos.example.carpooling.domain.enums.TravelRequestStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Schema(description = "Represents a travel request")
public class TravelRequest {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @Schema(description = "Travel passenger")
    Passenger passenger;

    @Schema(description = "Travel's place of origin")
    String origin;
    @Schema(description = "Travel's destination")
    String destination;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Travel Request Status")
    TravelRequestStatus status;

    @Schema(description = "Creation Date")
    Date creationDate;
}

