package com.hosteleria.service;

import java.util.ArrayList;

import com.hosteleria.model.Restaurante;

public interface RestauranteService {
	
	void altaRestaurante(Restaurante restaurante);
	ArrayList<Restaurante> listadoRestaurantes(String ciudad);
	ArrayList<Restaurante> listadoRestaurantesPorCalle(String ciudad, String calle);
	ArrayList<String> ubicacionRestaurante(String nombre, String ciudad);
}
