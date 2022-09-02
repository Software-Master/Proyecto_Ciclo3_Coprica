package com.ciclo3.proyecto_ciclo3_coprica;

import com.ciclo3.proyecto_ciclo3_coprica.entidades.Empresa;
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

    @GetMapping("/test")
    public String test(){
        Empresa emp = new Empresa("GESAMFOR","CAlle 17", "3007345956", "58558585-3");
        emp.setNombre("SOLAR LTDA");
        return emp.getNombre();
    }
    public static void main(String[] args) {
        SpringApplication.run(ProyectoCiclo3CopricaApplication.class, args);
    }

}
