package com.monica.practica.gestion_taller.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Appointment {

    private String nameClient;
    private LocalDate date;
    private LocalTime time;
    private Integer phoneNumber;
    private String plateNumber;
    private String motive;
    private Boolean newClient;
}
