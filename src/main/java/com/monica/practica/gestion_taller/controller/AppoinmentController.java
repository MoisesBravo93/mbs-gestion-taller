package com.monica.practica.gestion_taller.controller;

import com.monica.practica.gestion_taller.model.Appoinment;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/gestion-taller")
public class AppoinmentController {

    @GetMapping("/appoinment")
    public Appoinment getAppoinment() {
        Appoinment appoinmentCreate = new Appoinment();
        appoinmentCreate.setNameClient("Monica");
        appoinmentCreate.setPlateNumber("JXW7498");
        appoinmentCreate.setPhoneNumber(2345335);
        appoinmentCreate.setDate(LocalDate.of(2026, 3, 11));
        appoinmentCreate.setNewClient(true);
        appoinmentCreate.setMotive("asdfg");
        appoinmentCreate.setTime(LocalTime.of(15, 30));

        return appoinmentCreate;
    }

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

        return appoinmentCreate;
    }


}
