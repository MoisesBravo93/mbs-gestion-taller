package com.monica.practica.gestion_taller.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.monica.practica.gestion_taller.model.Appointment;
import com.monica.practica.gestion_taller.model.Car;
import com.monica.practica.gestion_taller.repository.AppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;

  public AppointmentService(AppointmentRepository appointmentRepository) {
    this.appointmentRepository = appointmentRepository;
  }

  public ResponseEntity<Appointment> postAppointment(Appointment newAppointment) {
    Appointment savedAppointment = appointmentRepository.save(newAppointment);
    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest().path("/appointment/{id}").buildAndExpand(savedAppointment.getId()).toUri();
    return ResponseEntity.created(location).body(savedAppointment);
  }

    public Optional<Appointment> getAppointment(Long id) {
      return appointmentRepository.findById(id);
    }

  public List<Appointment> getAllAppointments() {
    return appointmentRepository.findAll();
  }

  public String deleteAppointment(Long id) {
    appointmentRepository.deleteById(id);
    return "Deleted Appointment with ID:- " + id;
  }

}