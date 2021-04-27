package com.gtgsantos.example.carpooling.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Errors {

    List<Error> listError;
}
