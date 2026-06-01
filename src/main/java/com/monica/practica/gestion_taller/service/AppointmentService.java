package com.monica.practica.gestion_taller.service;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.monica.practica.gestion_taller.controller.AppointmentDuplicatedException;
import com.monica.practica.gestion_taller.controller.AppointmentNotFoundException;
import com.monica.practica.gestion_taller.model.Appointment;
import com.monica.practica.gestion_taller.model.Car;
import com.monica.practica.gestion_taller.model.Mechanic;
import com.monica.practica.gestion_taller.repository.AppointmentRepository;
import com.monica.practica.gestion_taller.repository.MechanicRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;
  private final MechanicRepository mechanicRepository;

  public AppointmentService(AppointmentRepository appointmentRepository, MechanicRepository mechanicRepository) {
    this.appointmentRepository = appointmentRepository;
    this.mechanicRepository = mechanicRepository;
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
    // Check: if not exists --> error, if exist --> delete
    if (!appointmentRepository.existsById(id)) {
      throw new AppointmentNotFoundException("Appointment with id " + id + " cannot be deleted because it does not exist");
    }
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

  // Mechanics

  public ResponseEntity<Mechanic> postMechanic(Mechanic newMechanic) {
    // Check: if exists --> error, if not --> save
    if (mechanicRepository.findByName(newMechanic.getName()).isPresent()) {
      throw new AppointmentDuplicatedException("Mechanic already exists");
    }

    Mechanic savedMechanic = mechanicRepository.save(newMechanic);
    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest().path("/mechanic/{id}").buildAndExpand(savedMechanic.getId()).toUri();
    return ResponseEntity.created(location).body(savedMechanic);
  }

  public Mechanic getMechanic(Long id) {
    return mechanicRepository.findById(id).orElseThrow(() ->
            new AppointmentNotFoundException("Mechanic with id " +  id + " not found"));
  }

  public List<Mechanic> getAllMechanics() {
    return mechanicRepository.findAll();
  }

  public String deleteMechanic(Long id) {
    // Check: if not exists --> error, if exist --> delete
    if(!mechanicRepository.existsById(id)) {
      throw new AppointmentNotFoundException("Mechanic with id " +  id + " cannot be deleted because it does not exist");
    }
    mechanicRepository.deleteById(id);
    return "Deleted Mechanic with ID:- " + id;
  }

  // Mechanic By Appointment

//  public Mechanic getMechanicByAppointment(Long id_appointment) {
//    return mechanicRepository.findByName(
//                    appointmentRepository.findById(id_appointment).get().getMechanic().getName())
//            .orElseThrow(() -> new AppointmentNotFoundException("Mechanic of appointment with id " +  id_appointment + " not found"));
//
//  }



}