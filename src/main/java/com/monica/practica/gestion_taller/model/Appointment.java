package com.monica.practica.gestion_taller.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name="appointments")

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameClient;
    private LocalDate date;
    private LocalTime time;
    private Integer phoneNumber;
    private String plateNumber;
    private String motive;
    private Boolean newClient;
}
