package com.hosteleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hosteleria.model.Restaurante;
import com.hosteleria.service.RestauranteService;

@RestController
public class RestauranteController {

	@Autowired
	RestauranteService service;
	
	// localhost:9080/crearRestaurante
	@PostMapping(value="/crearRestaurante")
	public void crearRestaurante(@RequestBody Restaurante restaurante) {
		service.altaRestaurante(restaurante);
	}
	
}
