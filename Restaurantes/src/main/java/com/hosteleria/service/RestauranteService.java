package com.hosteleria.service;

import java.util.List;

import com.hosteleria.model.Restaurante;

public interface RestauranteService {
	
	void altaRestaurante(Restaurante restaurante);
	List<Restaurante> listadoRestaurantes(String ciudad);
	
}
