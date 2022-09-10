package com.ciclo3.proyecto_ciclo3_coprica.service;

import com.ciclo3.proyecto_ciclo3_coprica.entidades.MovimientoDinero;
import com.ciclo3.proyecto_ciclo3_coprica.repositorio.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientosServices {

    @Autowired
    MovimientosRepository movimientosRepository;

    public List<MovimientoDinero> getAllMovimientos(){
        List<MovimientoDinero> movimientoList = new ArrayList<>();
        movimientosRepository.findAll().forEach(movimiento -> movimientoList.add(movimiento));
        return movimientoList;
    }

    public MovimientoDinero getMovimientoById(Integer id){
        return movimientosRepository.findById(id).get();
    }

    public ArrayList<MovimientoDinero> obtenerporEmpleado(Integer id){
        return movimientosRepository.findbyEmpleado(id);
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id){
        return movimientosRepository.findbyEmpresa(id);
    }

    public MovimientoDinero saveOrUpdateMovimiento(MovimientoDinero movimientoDinero){
        MovimientoDinero mov = movimientosRepository.save(movimientoDinero);
        return mov;
    }

    public boolean deleteMovimiento(Integer id){
        movimientosRepository.deleteById(id);

        if (this.movimientosRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }
}
