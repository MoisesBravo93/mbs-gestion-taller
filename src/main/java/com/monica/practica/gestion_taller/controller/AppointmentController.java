package com.monica.practica.gestion_taller.controller;

import com.monica.practica.gestion_taller.model.Appointment;
import com.monica.practica.gestion_taller.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestion-taller")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/appointment")
    public Appointment postAppointment(@RequestBody Appointment newAppointment) {

        return appointmentService.postAppointment(newAppointment);
    }

    @GetMapping("/appointment/{id}")
    public Appointment getAppointment(@PathVariable Long id) {

        return appointmentService.getAppointment(id);
    }

    @DeleteMapping("/appointment/{id}")
    public String deleteAppointment(@PathVariable Long id){

        return appointmentService.deleteAppointment(id);
    }

}

