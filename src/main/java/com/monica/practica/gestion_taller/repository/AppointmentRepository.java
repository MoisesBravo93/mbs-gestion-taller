package com.monica.practica.gestion_taller.repository;

import com.monica.practica.gestion_taller.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findAppointmentByNameClient(String nameClient);
}
