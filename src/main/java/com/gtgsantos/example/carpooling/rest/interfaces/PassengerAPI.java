package com.gtgsantos.example.carpooling.rest.interfaces;

import com.gtgsantos.example.carpooling.domain.entity.Passenger;
import com.gtgsantos.example.carpooling.rest.error.Errors;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name="Passenger", description = "Handle passenger's data")
public interface PassengerAPI {

    @Operation(description = "List all Passengers")
    List<Passenger> listPassengers();

    @Operation(
            description = "Finds a specific passenger",
            responses = { @ApiResponse(responseCode = "200",
                    description = "Response if passenger exists"),
                    @ApiResponse(responseCode = "404",
                            description = "Response if passenger's not found",
                            content = @Content(schema = @Schema(implementation = Errors.class))
                    )
            })
    Passenger findPassenger(@Parameter(description = "Passenger's id to be searched") Long id);

    @Operation(description = "Creates a new passenger")
    Passenger createPassenger(@Parameter(description = "Passenger's data to be created")  Passenger passenger);

    @Operation(description = "Updates passengers")
    Passenger updatePassenger(@Parameter(description = "Passenger's id to be updated") Long id,
                              @Parameter(description = "Passenger's data")  Passenger passenger);

    @Operation(description = "Deletes a passenger by id")
    public void deletePassenger(@Parameter(description=  "Passenger's id to be removed") Long id);
}
