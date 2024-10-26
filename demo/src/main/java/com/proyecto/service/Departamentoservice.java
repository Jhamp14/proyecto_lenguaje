package com.proyecto.service;

import com.proyecto.model.Departamento;
import com.proyecto.repository.Departamentorepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class Departamentoservice {

	private final Departamentorepository departamentorepository;

	public Departamentoservice(Departamentorepository departamentorepository) {
		this.departamentorepository = departamentorepository;
	}

	public List<Departamento> listaDepartamento() {
		return departamentorepository.findAll();
	}

	public Departamento guardarDepartamento(Departamento departamento) {
		return departamentorepository.save(departamento);
	}

	public Optional<Departamento> findById(Long id) {
		return departamentorepository.findById(id);
	}
	
	public void eliminarDepartamento(Long id) {
	    departamentorepository.deleteById(id);
	}

}
