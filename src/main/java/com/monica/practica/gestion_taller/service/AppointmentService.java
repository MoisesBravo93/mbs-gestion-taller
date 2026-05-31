package com.monica.practica.gestion_taller.service;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.monica.practica.gestion_taller.controller.AppointmentDuplicatedException;
import com.monica.practica.gestion_taller.controller.AppointmentNotFoundException;
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

  // Appointments

  public ResponseEntity<Appointment> postAppointment(Appointment newAppointment) {
    // Check: if exists --> error, if not --> save
    Optional<Appointment> aux = appointmentRepository.findAppointmentByNameClient(newAppointment.getNameClient());
    if (aux.isPresent()
            && newAppointment.getDate().equals(aux.get().getDate())
            && newAppointment.getTime().equals(aux.get().getTime())
    ) {
      throw new AppointmentDuplicatedException("Appointment already exists");
    }

    Appointment savedAppointment = appointmentRepository.save(newAppointment);
    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest().path("/appointment/{id}").buildAndExpand(savedAppointment.getId()).toUri();
    return ResponseEntity.created(location).body(savedAppointment);
  }

  public Appointment getAppointment(Long id) {
    return appointmentRepository.findById(id).orElseThrow(() ->
            new AppointmentNotFoundException("Appointment with id " +  id + " not found"));
  }

  public List<Appointment> getAllAppointments() {return appointmentRepository.findAll();}

  public String deleteAppointment(Long id) {
    appointmentRepository.deleteById(id);
    return "Deleted Appointment with ID:- " + id;
  }

  // Cars

  public Car getCar(Long id) {
    return appointmentRepository.findById(id).map(Appointment::getCar).orElseThrow(() ->
            new AppointmentNotFoundException("Car with id " +  id + " not found"));
  }

  public List<Car> getAllCars() {
    return appointmentRepository.findAll()
            .stream()
            .map(Appointment::getCar)
            .filter(Objects::nonNull)
            .distinct()
            .toList();
  }

}