package com.gtgsantos.example.carpooling.rest;

import com.gtgsantos.example.carpooling.domain.entity.Driver;
import com.gtgsantos.example.carpooling.domain.repository.DriverRepository;
import com.gtgsantos.example.carpooling.rest.interfaces.DriverAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path="/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverRest implements DriverAPI {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private DriverRepository repository;

    @GetMapping("/{id}")
    public Driver findDriver(@PathVariable("id") Long id) {
        Optional<Driver> optionalDriver = repository.findById(id);
        return optionalDriver.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return repository.save(driver);
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable("id") Long id) {
        repository.delete(findDriver(id));
    }

    @PutMapping("/{id}")
    public Driver updateDriver(@PathVariable("id") Long id, @RequestBody Driver driver) {
        Driver toUpdateDriver = findDriver(id);
        toUpdateDriver.setName(driver.getName());
        toUpdateDriver.setBirthDay(driver.getBirthDay());

        return repository.save(toUpdateDriver);
    }

    @GetMapping
    public CollectionModel<Driver> listDrivers(@RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Driver> driverPage = repository.findAll(PageRequest.of(page, PAGE_SIZE));
        CollectionModel<Driver> collectionModel = new CollectionModel(driverPage.getContent());

        Link lastPageLink = linkTo(methodOn(DriverRest.class).listDrivers(driverPage.getTotalPages() - 1))
                            .withRel("lastPage");

        return collectionModel.add(lastPageLink);
    }



}
