package com.hosteleria.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {
	
	@Id @Column(name="id_reserva")
	private int idReserva;
	
	@Column(name="id_restaurante")
	private int idRestaurante;
	
	@Column(name="id_usuario")
	private int idUsuario;
	
	@Column(name="nombre_reserva")
	private String nombreReserva;
	
	@Column(name="num_personas")
	private int numPersonas;
	
	private LocalDateTime fecha;

	public Reserva() {
		super();
	}

	public Reserva(int idRestaurante, int idUsuario, String nombreReserva, int numPersonas, LocalDateTime fecha) {
		super();
		this.idRestaurante = idRestaurante;
		this.idUsuario = idUsuario;
		this.nombreReserva = nombreReserva;
		this.numPersonas = numPersonas;
		this.fecha = fecha;
	}

	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreReserva() {
		return nombreReserva;
	}

	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}

	public int getNumPersonas() {
		return numPersonas;
	}
	
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public void NombreReserva(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
}
