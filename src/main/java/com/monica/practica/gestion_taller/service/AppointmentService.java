package com.monica.practica.gestion_taller.service;

import com.monica.practica.gestion_taller.model.Appointment;
import com.monica.practica.gestion_taller.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public Appointment postAppointment (Appointment newAppointment){
        return appointmentRepository.save(newAppointment);
    }

    // Para un solo appointment por id
    public Appointment getAppointment (Long id){
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        return optionalAppointment.get();
    }

    // Para todos los appointments
    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public void deleteAppointment (Long id){
        appointmentRepository.deleteById(id);
    }










}
