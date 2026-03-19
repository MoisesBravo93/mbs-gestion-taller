package com.monica.practica.gestion_taller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.monica.practica.gestion_taller")
@EnableJpaRepositories("com.monica.practica.gestion_taller.repository")
public class GestionTallerApplication {

  public static void main(String[] args) {
    SpringApplication.run(GestionTallerApplication.class, args);
  }

}
