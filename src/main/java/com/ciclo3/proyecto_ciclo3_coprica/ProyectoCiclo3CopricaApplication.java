package com.ciclo3.proyecto_ciclo3_coprica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class ProyectoCiclo3CopricaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProyectoCiclo3CopricaApplication.class, args);
    }

}
