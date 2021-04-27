package com.gtgsantos.example.carpooling.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Entity
public class Passenger {

    @Id
    @GeneratedValue
    Long id;

    @Schema(description = "Passenger's name")
    @Size(min=2, max=255)
    String name;


}
