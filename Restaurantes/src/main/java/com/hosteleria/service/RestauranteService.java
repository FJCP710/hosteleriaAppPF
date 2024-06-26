package com.hosteleria.service;

import java.util.ArrayList;

import com.hosteleria.model.Restaurante;

public interface RestauranteService {
	
	void altaRestaurante(Restaurante restaurante);
	ArrayList<Restaurante> listadoRestaurantes(String ciudad);
	ArrayList<Restaurante> listadoRestaurantesPorCalle(String ciudad, String calle);
	String ubicacionRestaurante(String nombre, String ciudad);
	void bajaRestaurante(Restaurante restaurante);
	void modificarRestaurante(Restaurante restaurante);
	boolean comprobarCorreoYContra(String correo, String contra);
	int cogerIdPorRazonSocial(String razonSocial);
	Integer cogerIdPorCorreo(String correo);
}
