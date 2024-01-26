package com.hosteleria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurante")
public class Restaurante {
	
	@Id @Column(name="id_restaurante")
	private int id_restaurante;
	
	@Column(name="nombre_comercial")
	private String nombreComercial;
	
	@Column(name="razon_social")
	private String razonSocial;
	
	private String ubicacion;
	private int aforo;
	
	@Column(name="mesas_disponibles")
	private int mesasDisponibles;
	
	@Column(name="reservar_local")
	private boolean reservarLocal;
	
	private String correo;

	public Restaurante() {
		super();
	}

	public Restaurante(String nombreComercial, String ubicacion, int aforo, int mesasDisponibles, boolean reservarLocal, String correo) {
		super();
		this.nombreComercial = nombreComercial;
		this.ubicacion = ubicacion;
		this.aforo = aforo;
		this.mesasDisponibles = mesasDisponibles;
		this.reservarLocal = reservarLocal;
		this.correo = correo;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public int getMesasDisponibles() {
		return mesasDisponibles;
	}

	public void setMesasDisponibles(int mesasDisponibles) {
		this.mesasDisponibles = mesasDisponibles;
	}

	public boolean isReservarLocal() {
		return reservarLocal;
	}

	public void setReservarLocal(boolean reservarLocal) {
		this.reservarLocal = reservarLocal;
	}

	public int getId_restaurante() {
		return id_restaurante;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
