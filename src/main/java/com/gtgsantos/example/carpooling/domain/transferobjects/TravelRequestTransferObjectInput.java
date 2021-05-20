package com.gtgsantos.example.carpooling.domain.transferobjects;

import com.gtgsantos.example.carpooling.domain.enums.TravelRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class TravelRequestTransferObjectInput {

    @NotNull(message = "O campo passengerId não pode ser nulo.")
    private Long passengerId;

    @NotEmpty(message = "O campo origin não pode estar em branco.")
    private String origin;

    @NotEmpty(message = "O campo destination não pode estar em branco.")
    private String destination;

    private TravelRequestStatus status;
}
