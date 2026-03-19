package com.monica.practica.gestion_taller.service;

import java.util.List;
import java.util.Optional;

import com.monica.practica.gestion_taller.model.Appointment;
import com.monica.practica.gestion_taller.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;

  public AppointmentService(AppointmentRepository appointmentRepository) {
    this.appointmentRepository = appointmentRepository;
  }

  public Appointment postAppointment(Appointment newAppointment) {
    return appointmentRepository.save(newAppointment);
  }

  // Para un solo appointment por id
  public Appointment getAppointment(Long id) {
    Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
    return optionalAppointment.get();
  }

  // Para todos los appointments
  public List<Appointment> getAllAppointments() {
    return appointmentRepository.findAll();
  }

  public void deleteAppointment(Long id) {
    appointmentRepository.deleteById(id);
  }

}
