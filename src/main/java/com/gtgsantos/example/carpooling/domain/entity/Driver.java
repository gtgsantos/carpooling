package com.gtgsantos.example.carpooling.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@Entity
@Schema(description = "Represents a drive inside platform")
public class Driver {

    @Id
    @GeneratedValue
    Long driverId;

    @Schema(description = "Driver's name")
    @Size(min=2, max=255)
    String name;

    @Schema(description = "Driver's  Birthday")
    Date birthDay;
}
