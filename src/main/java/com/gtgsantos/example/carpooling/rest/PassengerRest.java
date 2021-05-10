package com.gtgsantos.example.carpooling.rest;

import com.gtgsantos.example.carpooling.domain.entity.Passenger;
import com.gtgsantos.example.carpooling.domain.repository.PassengerRepository;
import com.gtgsantos.example.carpooling.rest.interfaces.PassengerAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(path="/passengers", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassengerRest implements PassengerAPI {

    @Autowired
    PassengerRepository passengerRepository;

    @GetMapping
    public List<Passenger> listPassengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger findPassenger(@PathVariable("id") Long id) {
        return passengerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
//    @RolesAllowed("ROLE_ADMIN")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger) {
        Passenger p = findPassenger(id);
        p.setName(passenger.getName());
        return passengerRepository.save(p);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable("id") Long id) {
        passengerRepository.delete(findPassenger(id));
    }
}
