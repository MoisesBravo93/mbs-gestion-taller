package com.monica.practica.gestion_taller.controller;

import java.util.List;

import com.monica.practica.gestion_taller.model.Appointment;
import com.monica.practica.gestion_taller.model.Car;
import com.monica.practica.gestion_taller.model.Mechanic;
import com.monica.practica.gestion_taller.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestion-taller")
public class AppointmentController {

  private final AppointmentService appointmentService;

  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @PostMapping("/appointment")
  public ResponseEntity<Appointment> postAppointment(@Validated(Appointment.AppointmentsValidate.class) @RequestBody Appointment newAppointment) {
    return appointmentService.postAppointment(newAppointment);
  }

  @GetMapping("/appointment/{id}")
  public Appointment getAppointment(@PathVariable Long id) {return appointmentService.getAppointment(id);}

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
  public Car getCar(@PathVariable Long id) { return appointmentService.getCar(id); }

  @GetMapping("/appointments/cars")
  public List<Car> getAllCars(){ return appointmentService.getAllCars(); }

  // Mechanics

  @PostMapping("/mechanic")
  public ResponseEntity<Mechanic> postMechanic( @Validated(Mechanic.MechanicValidate.class) @RequestBody Mechanic newMechanic) {
    return appointmentService.postMechanic(newMechanic);
  }

  @GetMapping("/mechanic/{id}")
  public Mechanic getMechanic(@PathVariable Long id) {return appointmentService.getMechanic(id);}

  @GetMapping("/mechanics")
  public List<Mechanic> getAllMechanics(){return appointmentService.getAllMechanics();}

  @DeleteMapping("/mechanic/{id}")
  public String deleteMechanic(@PathVariable Long id) {
    return appointmentService.deleteMechanic(id);
  }

  // Mechanic By Appointment

//  @GetMapping("/mechanic/appointment{id}")
//  public Mechanic getMechanicByAppointment(@PathVariable Long id) {return appointmentService.getMechanicByAppointment(id);}



}

