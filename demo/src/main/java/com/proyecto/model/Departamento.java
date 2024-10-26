package com.proyecto.model;

import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name="departamentos")

public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	
	private String nombre;
	@Column(nullable = false)
	private String ubicacion;
	
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Empleado> empleados;
	
	public Departamento() {}

	public Departamento(Long id, String nombre, String ubicacion, List<Empleado> empleados) {
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.empleados = empleados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	
}
