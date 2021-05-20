package com.gtgsantos.example.carpooling.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class DefaultErrorHandling {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Errors handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return new Errors(ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(field -> new Error(field.getDefaultMessage()))
                .collect(Collectors.toList()));

    }
}
