package com.monica.practica.gestion_taller.controller;

public class AppointmentDuplicatedException extends RuntimeException {
    public AppointmentDuplicatedException(String message) {
        super(message);
    }
}
