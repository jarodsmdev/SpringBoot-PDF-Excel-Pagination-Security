package com.gestionempleados.servicio;

import com.gestionempleados.entidades.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpleadoService {
    public List<Empleado> findAll();
    public Page<Empleado> findAll(Pageable pageable);
    public void save(Empleado empleado);
    public Empleado findOne(Long id);
    public void delete(Long id);
}
