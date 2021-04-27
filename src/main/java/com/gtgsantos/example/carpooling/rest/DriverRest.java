package com.gtgsantos.example.carpooling.rest;

import com.gtgsantos.example.carpooling.domain.entity.Driver;
import com.gtgsantos.example.carpooling.domain.repository.DriverRepository;
import com.gtgsantos.example.carpooling.rest.interfaces.DriverAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverRest implements DriverAPI {

    @Autowired
    private DriverRepository repository;

    @GetMapping("/drivers/{id}")
    public Driver findDriver(@PathVariable("id") Long id) {
        Optional<Driver> optionalDriver = repository.findById(id);
        return optionalDriver.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/drivers")
    public Driver createDriver(@RequestBody Driver driver) {
        return repository.save(driver);
    }

    @DeleteMapping("/drivers/{id}")
    public void deleteDriver(@PathVariable("id") Long id) {
        repository.delete(findDriver(id));
    }

    @PutMapping("/drivers/{id}")
    public Driver updateDriver(@PathVariable("id") Long id, @RequestBody Driver driver) {
        Driver toUpdateDriver = findDriver(id);
        toUpdateDriver.setName(driver.getName());
        toUpdateDriver.setBirthDay(driver.getBirthDay());

        return repository.save(toUpdateDriver);
    }

    @GetMapping("/drivers")
    public List<Driver> listDrivers() {
        return repository.findAll();
    }
}
