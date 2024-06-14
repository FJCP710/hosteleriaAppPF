package com.hosteleria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="promociones")
public class Promocion {
	
	
	@Id @Column(name="id_promociones")
	private int idPromociones;
	
	@Column(name="id_restaurante")
	private int idRestaurante;
	
	@Column(name="id_producto")
	private int idProducto;
	
	private Double porcentaje;
	
	@Column(name="precio_min")
	private Double precioMin;

	public Promocion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Promocion(int idRestaurante, int idProducto,	Double porcentaje, Double precioMin) {
		super();
		this.idRestaurante = idRestaurante;
		this.idProducto = idProducto;
		this.porcentaje = porcentaje;
		this.precioMin = precioMin;
	}

	public int getIdPromociones() {
		return idPromociones;
	}

	public void setIdPromociones(int idPromociones) {
		this.idPromociones = idPromociones;
	}

	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Double getPrecioMin() {
		return precioMin;
	}

	public void setPrecionMin(Double precioMin) {
		this.precioMin = precioMin;
	}

	public int getIdProducto() {
		return idProducto;
	}
	
	
}
