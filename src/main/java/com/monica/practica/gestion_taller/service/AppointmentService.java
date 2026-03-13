package com.monica.practica.gestion_taller.service;

import com.monica.practica.gestion_taller.model.Appointment;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    public Appointment postAppointment (Appointment newAppointment){
        Appointment appointmentCreate = new Appointment();
        if(newAppointment != null){
            appointmentCreate.setNameClient(newAppointment.getNameClient());
            appointmentCreate.setPlateNumber(newAppointment.getPlateNumber());
            appointmentCreate.setPhoneNumber(newAppointment.getPhoneNumber());
            appointmentCreate.setDate(newAppointment.getDate());
            appointmentCreate.setNewClient(newAppointment.getNewClient());
            appointmentCreate.setMotive(newAppointment.getMotive());
            appointmentCreate.setTime(newAppointment.getTime());
//            Save in DB
        }

        return appointmentCreate;
    }

    public Appointment getAppointment (Long id){
//      if(appointment(id) != null){
//            return null;
//        }
//        Search in DB
        Appointment appointment = new Appointment();
//        appointment = appointment(id);


        return appointment;
    }

    public String deleteAppointment (Long id){
//        if(appointment(id) != null){
//            return "Appointment does not exist.";
//        }
//        Delete in DB

        return "Appointment deleted.";
    }










}
