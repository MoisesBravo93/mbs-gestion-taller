package com.monica.practica.gestion_taller.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class Appointment {

  public interface AppointmentsValidate {}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name_client")
  @NotBlank(groups = AppointmentsValidate.class, message = "Name required")
  private String nameClient;

  @Column(name = "new_client")
  private Boolean newClient;

  @Column(name = "phone_number")
  @NotNull(groups = AppointmentsValidate.class, message = "Phone number required")
  private Integer phoneNumber;

  @Column(name = "motive")
  private String motive;

  @Column(name = "date")
  @NotNull(groups = AppointmentsValidate.class, message = "Date required")
  private LocalDate date;

  @Column(name = "time")
  @NotNull(groups = AppointmentsValidate.class, message = "Time required")
  private LocalTime time;

  @OneToOne(cascade = CascadeType.ALL) // Cascade.ALL --> any operation performed on appointment entity should also be performed on the car entity
  @JoinColumn(name = "car_id", referencedColumnName = "id") // Foreign Key
  private Car car;

//  @ManyToOne
//  @JoinColumn(name = "mechanic_name", referencedColumnName = "name")
//  private Mechanic mechanic;

}
