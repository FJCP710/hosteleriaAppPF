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
	private String ubicacion;
	private int aforo;
	
	@Column(name="mesas_disponibles")
	private int mesasDisponibles;
	
	@Column(name="reservar_local")
	private boolean reservarLocal;

	public Restaurante() {
		super();
	}

	public Restaurante(String ubicacion, int aforo, int mesasDisponibles, boolean reservarLocal) {
		super();
		this.ubicacion = ubicacion;
		this.aforo = aforo;
		this.mesasDisponibles = mesasDisponibles;
		this.reservarLocal = reservarLocal;
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
}
