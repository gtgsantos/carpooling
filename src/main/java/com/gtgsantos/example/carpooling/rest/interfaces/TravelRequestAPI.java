package com.gtgsantos.example.carpooling.rest.interfaces;


import com.gtgsantos.example.carpooling.domain.entity.Passenger;
import com.gtgsantos.example.carpooling.domain.entity.TravelRequest;
import com.gtgsantos.example.carpooling.error.Errors;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Travel Request", description = "Handle travel request's data")
public interface TravelRequestAPI {

    @Operation(
            description = "Finds a specific travel request",
            responses = { @ApiResponse(responseCode = "200",
                    description = "Response if travel request exists"),
                    @ApiResponse(responseCode = "404",
                            description = "Response if travel request's not found",
                            content = @Content(schema = @Schema(implementation = Errors.class))
                    )
            })
    TravelRequest findTravelRequest(@Parameter(description = "Travel Request's id to be searched") Long id);

    @Operation(
            description = "Create a travel request",
            responses = { @ApiResponse(responseCode = "200",description = "Response if travel request exists"),
                    @ApiResponse(responseCode = "404", description = "Response if travel request's not found",
                            content = @Content(schema = @Schema(implementation = Errors.class))
                    )
            })
    void createTravelRequest(@Parameter(description = "New Travel request") TravelRequest travelRequest);
}
