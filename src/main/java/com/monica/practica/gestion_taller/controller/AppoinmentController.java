package com.monica.practica.gestion_taller.controller;

import com.monica.practica.gestion_taller.model.Appoinment;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/gestion-taller")
public class AppoinmentController {

    @PostMapping("/appoinment")
    public Appoinment postAppoinment(@RequestBody Appoinment newAppoinment) {
        Appoinment appoinmentCreate = new Appoinment();
        appoinmentCreate.setNameClient(newAppoinment.getNameClient());
        appoinmentCreate.setPlateNumber(newAppoinment.getPlateNumber());
        appoinmentCreate.setPhoneNumber(newAppoinment.getPhoneNumber());
        appoinmentCreate.setDate(newAppoinment.getDate());
        appoinmentCreate.setNewClient(newAppoinment.getNewClient());
        appoinmentCreate.setMotive(newAppoinment.getMotive());
        appoinmentCreate.setTime(newAppoinment.getTime());
        //guardamos en la bd

        return appoinmentCreate;
    }

    @GetMapping("/appoinment/{id}")
    public String getAppoinment(@PathVariable Long id) {
//        if(si cita no existe){
//            return "Appoinment does not exist";
//        }
        //Lo buscamos en la bd

        return "Appoinmnent with id(" + id + "): ";
    }

    @DeleteMapping("/appoinment/{id}")
    public String deleteAppoinment(@PathVariable Long id){
//        if( si cita no existe  ){
//            return "Appointment does not exist";
//        }
        //borramos de la bd

        return "Appoinmnent with id(" + id + ") deleted.";
    }

}

