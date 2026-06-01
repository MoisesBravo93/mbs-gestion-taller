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

        return buildResponse( e.getMessage(), errors, HttpStatus.BAD_REQUEST.value());
    }

    // Appointment Not Found Error
    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleAppointmentNotFound(AppointmentNotFoundException e){
        return buildResponse( e.getMessage(), null, HttpStatus.NOT_FOUND.value());
    }

    // Duplicate Appointment Error
    @ExceptionHandler(AppointmentDuplicatedException.class)
    public ResponseEntity<Map<String,Object>> handleAppointmentDuplicated(AppointmentDuplicatedException e){
        return buildResponse( e.getMessage(), null, HttpStatus.BAD_REQUEST.value());
    }

    // Response Errors List
    private ResponseEntity<Map<String, Object>> buildResponse(String message,  Map<String, List<String>> errors, int status){

        Map<String, Object> response = new HashMap<>();
        response.put("Timestamp", LocalDateTime.now());
        response.put("Status", status);
        response.put("Message", message);
        if(errors!=null){response.put("Errors", errors);}

        return ResponseEntity.badRequest().body(response);
    }

}
