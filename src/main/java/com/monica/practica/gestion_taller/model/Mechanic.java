package com.monica.practica.gestion_taller.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mechanic")
public class Mechanic {

    public interface MechanicValidate {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(groups = Mechanic.MechanicValidate.class, message = "Name required")
    private String name;

//    @Column(name = "appointments")
//    @OneToMany(mappedBy = "mechanic")
//    private List<Appointment>  appointments;

}
