package com.gtgsantos.example.carpooling.domain.transferobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class TravelRequestTransferObjectInput {

    @NotNull(message = "O campo passengerId não pode ser nulo")
    Long passengerId;

    @NotEmpty(message = "O campo origin não pode estar em branco")
    String origin;

    @NotEmpty(message = "O campo destination não pode estar em branco")
    String destination;
}
