package com.gtgsantos.example.carpooling.rest.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class DefaultErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Errors handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return new Errors(ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::getMessage)
                .collect(Collectors.toList()));

    }

    private Error getMessage(FieldError err) {
        return new Error(messageSource.getMessage(err, LocaleContextHolder.getLocale()));
    }

}
