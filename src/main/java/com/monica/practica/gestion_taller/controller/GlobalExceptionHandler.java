package com.monica.practica.gestion_taller.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Generic exceptions --> Return error HTTP 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception e) {
        return ResponseEntity.internalServerError().body("Internal Server Error");
    }

    // Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidationErrors(MethodArgumentNotValidException e){

        Map<String, List<String>> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(
                        error -> error.getField(),
                        Collectors.mapping(error -> error.getDefaultMessage(), Collectors.toList())
                        )
                );

        return buildResponse("Validation errors", errors);
    }

    // Response errors list
    private ResponseEntity<Map<String, Object>> buildResponse(String message,  Map<String, List<String>> errors){

        Map<String, Object> response = new HashMap<>();
        response.put("Timestamp", LocalDateTime.now());
        response.put("Status", HttpStatus.BAD_REQUEST.value());
        response.put("Message", message);
        response.put("Errors", errors);

        return ResponseEntity.badRequest().body(response);
    }

}
