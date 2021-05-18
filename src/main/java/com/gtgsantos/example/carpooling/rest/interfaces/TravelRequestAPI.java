package com.gtgsantos.example.carpooling.rest.interfaces;


import com.gtgsantos.example.carpooling.domain.transferobjects.TravelRequestTransferObjectInput;
import com.gtgsantos.example.carpooling.domain.transferobjects.TravelRequestTransferObjectOutput;
import com.gtgsantos.example.carpooling.error.Errors;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.EntityModel;

import java.util.List;

@Tag(name="Travel Request", description = "Handle travel request's data")
public interface TravelRequestAPI {

    @Operation(
            description = "Finds a specific travel request",
            responses = { @ApiResponse(responseCode = "200",
                    description = "Response if List of travels exists"),
                    @ApiResponse(responseCode = "404",
                            description = "Response if there's no travel nearby",
                            content = @Content(schema = @Schema(implementation = Errors.class))
                    )
            })
    List<EntityModel<TravelRequestTransferObjectOutput>> findTravelRequest(@Parameter(description = "Current Driver's Address to find nearby Travels") String currentAddress);

    @Operation(
            description = "Create a travel request",
            responses = { @ApiResponse(responseCode = "200",description = "Response if travel request exists"),
                    @ApiResponse(responseCode = "404", description = "Response if travel request's not found",
                            content = @Content(schema = @Schema(implementation = Errors.class))
                    )
            })
    EntityModel<TravelRequestTransferObjectOutput> makeTravelRequest(@Parameter(description = "New Travel request") TravelRequestTransferObjectInput travelRequestTransferObjectInput);
}
