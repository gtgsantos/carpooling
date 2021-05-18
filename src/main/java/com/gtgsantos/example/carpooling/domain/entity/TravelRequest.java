package com.gtgsantos.example.carpooling.domain.entity;

import com.gtgsantos.example.carpooling.domain.enums.TravelRequestStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@Schema(description = "Represents a travel request")
@NoArgsConstructor
@AllArgsConstructor
public class TravelRequest {

    @Id
    @GeneratedValue
    Long travelId;

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

