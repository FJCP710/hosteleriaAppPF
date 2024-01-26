package com.hosteleria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// localhost:9080/buscarRestaurantesCiudad
	@GetMapping(value="/buscarRestaurantesCiudad", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Restaurante> buscarRestaurante(@RequestParam("ciudad") String ciudad){
		return service.listadoRestaurantes(ciudad);
	}
	
}
