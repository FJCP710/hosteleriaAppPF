package com.hosteleria.model;

import java.util.ArrayList;

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
	
	@Column(name="productos_rebajados")
	private ArrayList<String> productosRebajados;
	private int porcentaje;
	
	@Column(name="precio_min")
	private double precionMin;

	public Promocion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Promocion(int idRestaurante, int idProducto, ArrayList<String> productosRebajados,
			int porcentaje, double precionMin) {
		super();
		this.idRestaurante = idRestaurante;
		this.idProducto = idProducto;
		this.productosRebajados = productosRebajados;
		this.porcentaje = porcentaje;
		this.precionMin = precionMin;
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

	public ArrayList<String> getProductosRebajados() {
		return productosRebajados;
	}

	public void setProductosRebajados(ArrayList<String> productosRebajados) {
		this.productosRebajados = productosRebajados;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public double getPrecionMin() {
		return precionMin;
	}

	public void setPrecionMin(double precionMin) {
		this.precionMin = precionMin;
	}

	public int getIdProducto() {
		return idProducto;
	}
	
	
}
