package com.monica.practica.gestion_taller.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name_client")
  private String nameClient;

  @Column(name = "new_client")
  private Boolean newClient;

  @Column(name = "phone_number")
  private Integer phoneNumber;

  @Column(name = "motive")
  private String motive;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "time")
  private LocalTime time;

  @OneToOne(cascade = CascadeType.ALL) // Cascade.ALL --> any operation performed on appointment entity should also be performed on the car entity
  @JoinColumn(name = "car_id", referencedColumnName = "id") // Foreing Key
  private Car car;

}
