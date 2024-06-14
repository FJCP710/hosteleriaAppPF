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
	
	private String calle;
	private int numero;
	private String ciudad;
	private int aforo;
	
	@Column(name="mesas_disponibles")
	private int mesasDisponibles;
	
	@Column(name="reservar_local")
	private boolean reservarLocal;
	
	private String correo;
	
	private String contra;

	public Restaurante() {
		super();
	}

	public Restaurante(String nombreComercial, String calle, int numero, String ciudad, int aforo, int mesasDisponibles, boolean reservarLocal, String correo, String contra) {
		super();
		this.nombreComercial = nombreComercial;
		this.calle = calle;
		this.ciudad = ciudad;
		this.numero = numero;
		this.aforo = aforo;
		this.mesasDisponibles = mesasDisponibles;
		this.reservarLocal = reservarLocal;
		this.correo = correo;
		this.contra = contra;
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

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}
}
