package com.monica.practica.gestion_taller.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appoinment {

    private String nameClient;
    private LocalDate date;
    private LocalTime time;
    private Integer phoneNumber;
    private String plateNumber;
    private String motive;
    private Boolean newClient;

}
