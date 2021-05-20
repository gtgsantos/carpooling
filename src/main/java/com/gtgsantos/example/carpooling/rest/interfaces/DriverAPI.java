package com.gtgsantos.example.carpooling.rest.interfaces;

import com.gtgsantos.example.carpooling.domain.entity.Driver;
import com.gtgsantos.example.carpooling.rest.error.Errors;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name="Driver", description = "Handle driver's data")
public interface DriverAPI {

    @Operation(
            description = "Finds a specific driver",
            responses = { @ApiResponse(responseCode = "200",
                                        description = "Response if driver exists"),
                            @ApiResponse(responseCode = "404",
                                         description = "Response if driver's not found",
            content = @Content(schema = @Schema(implementation = Errors.class))
                    )
            })
    Driver findDriver(@Parameter(description="Driver's id to be searched") Long id);

    Driver createDriver(@Parameter(description = "Driver's data to be created") Driver driver);

    @Operation(description = "Deletes a driver by id")
    void deleteDriver(@Parameter(description=  "Driver's id to be removed") Long id);

    Driver updateDriver(@Parameter(description= "Driver's it to be updated") Long id, @RequestBody Driver driver);

    @Operation(description = "List all drivers")
    List<Driver> listDrivers() ;
}
