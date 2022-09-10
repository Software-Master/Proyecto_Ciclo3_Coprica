package com.ciclo3.proyecto_ciclo3_coprica.controller;

import com.ciclo3.proyecto_ciclo3_coprica.entidades.Empleado;
import com.ciclo3.proyecto_ciclo3_coprica.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/users")
    public List<Empleado> verEmpleados(){
        return empleadoService.getAllEmpleado();
    }

    @PostMapping("/users")
    public Optional<Empleado> guardarEmpleado(@RequestBody Empleado empl){
        return Optional.ofNullable(this.empleadoService.saveOrUpdateEmpleado(empl));
    }

    @GetMapping(path = "users/{id}")
    public Optional<Empleado> empleadoPorID(@PathVariable("id") Integer id){
        return this.empleadoService.getEmpleadoById(id);
    }
    //Traemos todos los empleados de una empresa
    @GetMapping("/enterprises/{id}/users")
    public ArrayList<Empleado> EmpleadosPorEmpresa(@PathVariable("id") Integer id){
        return this.empleadoService.obtenerPorEmpresa(id);
    }

    @PatchMapping("/users/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado){
        Empleado empl = empleadoService.getEmpleadoById(id).get();

        empl.setNombre(empleado.getNombre());
        empl.setCorreo(empleado.getCorreo());
        empl.setEmpresa(empleado.getEmpresa());
        empl.setRol(empleado.getRol());

        return this.empleadoService.saveOrUpdateEmpleado(empl);
    }

    @DeleteMapping("/users/{id}")
    public String DeleteEmpleado(@PathVariable("id") Integer id){
        boolean respuesta = empleadoService.deleteEmpleado(id);
        if (respuesta){
            return "se elimino con exito al empleado con id: "+id;
        }
        return "No se pudo eliminar correctamente el empleado con id: "+id;
    }
}
