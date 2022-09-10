package com.ciclo3.proyecto_ciclo3_coprica.repositorio;

import com.ciclo3.proyecto_ciclo3_coprica.entidades.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovimientosRepository extends JpaRepository<MovimientoDinero, Integer> {

    @Query(value = "SELECT * FROM movimientos where empleado_id=?1", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findbyEmpleado(Integer id);

    //Metodo para filtrar movimeintos por empresa
    @Query(value = "select * from movimientos where empleado_id in (select id from empleado where empresa_id=?1)",nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findbyEmpresa(Integer id);
}
