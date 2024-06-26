package com.hosteleria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id @Column(name="id_producto")
	private int idProducto;
	
	private String nombre;
	private double precio;
	private String dimension;
	
	public Producto() {
		super();
	}
	
	public Producto(String nombre, double precio, String dimension) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.dimension = dimension;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
}
