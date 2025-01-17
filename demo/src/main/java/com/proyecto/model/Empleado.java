package com.proyecto.model;

import jakarta.persistence.*;
@Entity
@Table(name="empleados")

public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String apellido;

	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private int celular;
	
	@Column(nullable = false)
	private double sueldo;
	
	@Column(nullable = false)
	private long id_departamento;

	 @ManyToOne
	    @JoinColumn(name = "departamento_id") // Esta es la clave foránea
	    private Departamento departamento;
	
	public Empleado() {}

	public Empleado(long id, String nombre, String apellido, String email, int celular, double sueldo,
			long id_departamento, Departamento departamento) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.celular = celular;
		this.sueldo = sueldo;
		this.id_departamento = id_departamento;
		this.departamento = departamento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public long getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(long id_departamento) {
		this.id_departamento = id_departamento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
