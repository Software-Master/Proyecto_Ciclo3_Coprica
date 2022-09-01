package com.ciclo3.proyecto_ciclo3_coprica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class ProyectoCiclo3CopricaApplication {

    @GetMapping("/hello")
    public String hello(){
        return "Hola ciclo 3";
    }
    public static void main(String[] args) {
        SpringApplication.run(ProyectoCiclo3CopricaApplication.class, args);
    }

}
