package com.ciclo3.proyecto_ciclo3_coprica.controller;

import com.ciclo3.proyecto_ciclo3_coprica.entidades.MovimientoDinero;
import com.ciclo3.proyecto_ciclo3_coprica.service.MovimientosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovimientosController {

    @Autowired
    MovimientosServices movimientosServices;

    @GetMapping("/enterprises/movements")
    public List<MovimientoDinero> verMovimientos(){

        return movimientosServices.getAllMovimientos();
    }

    @PostMapping("/enterprises/movements")
    public MovimientoDinero guardarMovimiento(@RequestBody MovimientoDinero movimiento){
        return movimientosServices.saveOrUpdateMovimiento(movimiento);
    }

    @GetMapping("/enterprises/{id}/movements")
    public MovimientoDinero movimientoPorID(@PathVariable("id") Integer id){
        return movimientosServices.getMovimientoById(id);
    }

    @PatchMapping("/enterprises/{id}/movements")
    public MovimientoDinero actualizarMovimiento(@PathVariable("id") Integer id, @RequestBody MovimientoDinero movimiento){
        MovimientoDinero mov = movimientosServices.getMovimientoById(id);
        mov.setConcepto(movimiento.getConcepto());
        mov.setMonto(movimiento.getMonto());
        mov.setUsuario(movimiento.getUsuario());

        return movimientosServices.saveOrUpdateMovimiento(mov);
    }

    @DeleteMapping("/enterprises/{id}/movements")
    public String deleteMovimiento(@PathVariable("id") Integer id){
        boolean respuesta = movimientosServices.deleteMovimiento(id);

        if (respuesta){
            return "Se elimino correctamente el movimiento con Id: "+id;
        }
        return "No se pudo eliminar el movimiento con la Id: "+id;
    }

    @GetMapping("/users/{id}/movements")
    public ArrayList<MovimientoDinero> movimientosPorEmpleado(@PathVariable("id") Integer id){
        return movimientosServices.obtenerporEmpleado(id);
    }

    @GetMapping("/empresa/enterprises/{id}/movements")
    public ArrayList<MovimientoDinero> movimientosPorEmpresa(@PathVariable("id") Integer id){
        return movimientosServices.obtenerPorEmpresa(id);
    }
}
