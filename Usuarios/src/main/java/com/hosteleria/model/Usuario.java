package com.hosteleria.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id @Column(name="id_usuario")
	private int id_usuario;
	private String nombre;
	private String apellido;
	
	@Column(name="fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	private String usuario;
	private String contra;
	private String correo;
	
	public Usuario() {
		super();
	}

	public Usuario(int id_usuario, String nombre, String apellido, LocalDate fechaNacimiento, String usuario, String contra,
			String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.usuario = usuario;
		this.contra = contra;
		this.correo = correo;
	}

	public int getId_usuario() {
		return id_usuario;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
