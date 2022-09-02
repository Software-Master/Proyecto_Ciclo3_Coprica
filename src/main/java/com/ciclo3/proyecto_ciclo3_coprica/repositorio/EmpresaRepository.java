package com.ciclo3.proyecto_ciclo3_coprica.repositorio;

import com.ciclo3.proyecto_ciclo3_coprica.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
