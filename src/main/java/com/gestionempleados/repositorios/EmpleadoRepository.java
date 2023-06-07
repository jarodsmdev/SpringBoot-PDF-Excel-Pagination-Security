package com.gestionempleados.repositorios;

import com.gestionempleados.entidades.Empleado;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmpleadoRepository extends PagingAndSortingRepository <Empleado,Long> {

}
