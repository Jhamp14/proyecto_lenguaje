package com.proyecto.repository;

import com.proyecto.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Empleadorepository extends JpaRepository<Empleado, Long>{

}