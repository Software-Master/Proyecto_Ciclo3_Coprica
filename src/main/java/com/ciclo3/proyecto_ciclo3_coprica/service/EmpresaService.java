package com.ciclo3.proyecto_ciclo3_coprica.service;

import com.ciclo3.proyecto_ciclo3_coprica.entidades.Empresa;
import com.ciclo3.proyecto_ciclo3_coprica.repositorio.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired // Conectamos esta clase con el repository de Empresa
    EmpresaRepository empresaRepository;

    //Metodo que me lista todas las empresas
    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;
    }
    //Metodo que me trae una sola empresa por su Id
    public Empresa getEmpresaById(Integer id){

        return empresaRepository.findById(id).get();
    }

    //Metodo para guardar o actualizar una empresa
    public Empresa saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp = empresaRepository.save(empresa);
        return emp;
    }
    //Metodo para eliminar una empresa
    public boolean deleteEmpresa(Integer id){
        empresaRepository.deleteById(id);
        if (empresaRepository.findById(id) != null){
            return true;
        }
        return false;
    }
}
