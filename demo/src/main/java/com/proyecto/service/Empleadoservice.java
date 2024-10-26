package com.proyecto.service;

import com.proyecto.model.Empleado;
import com.proyecto.repository.Empleadorepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Empleadoservice {

    private final Empleadorepository empleadorepository;

    @Autowired
    public Empleadoservice(Empleadorepository empleadorepository) {
        this.empleadorepository = empleadorepository;
    }

    public List<Empleado> listarEmpleados() {
        return empleadorepository.findAll(); 
    }

    public Optional<Empleado> findById(Long id) {
        return empleadorepository.findById(id);
    }

    public void guardarEmpleados(Empleado empleado) {
    	empleadorepository.save(empleado);
    }

    public void eliminarEmpleado(Long id) {
    	empleadorepository.deleteById(id); 
    }
}
