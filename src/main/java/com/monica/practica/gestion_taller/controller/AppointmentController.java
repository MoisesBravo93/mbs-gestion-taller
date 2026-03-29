package com.monica.practica.gestion_taller.controller;

import java.util.List;
import java.util.Optional;

import com.monica.practica.gestion_taller.model.Appointment;
import com.monica.practica.gestion_taller.model.Car;
import com.monica.practica.gestion_taller.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestion-taller")
public class AppointmentController {

  private final AppointmentService appointmentService;

  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @PostMapping("/appointment")
  public ResponseEntity<Appointment> postAppointment(@RequestBody Appointment newAppointment) {
    return appointmentService.postAppointment(newAppointment);
  }

  @GetMapping("/appointment/{id}")
  public Optional<Appointment> getAppointment(@PathVariable Long id) {
    return appointmentService.getAppointment(id);
  }

  @GetMapping("/appointments")
  public List<Appointment> getAllAppointments() {
    return appointmentService.getAllAppointments();
  }

  @DeleteMapping("/appointment/{id}")
  public String deleteAppointment(@PathVariable Long id) {
    return appointmentService.deleteAppointment(id);
  }

  // Cars

  @GetMapping("/appointment/{id}/car")
  public Optional<Car> getCar(@PathVariable Long id) { return appointmentService.getCar(id); }

  @GetMapping("/appointments/cars")
  public List<Car> getAllCars(){ return appointmentService.getAllCars(); }

}

