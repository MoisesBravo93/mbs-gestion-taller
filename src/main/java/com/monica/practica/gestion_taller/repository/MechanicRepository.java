package com.monica.practica.gestion_taller.repository;

import com.monica.practica.gestion_taller.model.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long>{
    Optional<Mechanic> findByName(String name);
}
