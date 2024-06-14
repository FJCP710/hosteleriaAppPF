package com.hosteleria.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hosteleria.model.Restaurante;
import com.hosteleria.service.RestauranteService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RestauranteController {

	@Autowired
	RestauranteService service;
	
	// localhost:9080/crearRestaurante
	@PostMapping(value="/crearRestaurante")
	public ResponseEntity<?> crearRestaurante(@RequestBody Restaurante restaurante) {
		service.altaRestaurante(restaurante);
		return ResponseEntity.ok("Usuario creado con éxito");
	}
	
	// localhost:9080/buscarRestaurantesCiudad
	@GetMapping(value="/buscarRestaurantesCiudad", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Restaurante> buscarRestaurante(@RequestParam("ciudad") String ciudad){
		return service.listadoRestaurantes(ciudad);
	}
	
	// localhost:9080/restaurantesPorCalle
	@GetMapping(value="/restaurantesPorCalle", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Restaurante> listadoRestaurantesPorCalle(@RequestParam("ciudad") String ciudad, @RequestParam("calle") String calle){
		return service.listadoRestaurantesPorCalle(ciudad, calle);
	}
	
	// localhost:9080/ubicacionRestaurante
	@GetMapping(value="/ubicacionRestaurante", produces = MediaType.APPLICATION_JSON_VALUE)
	public String ubicacionRestaurante(@RequestParam("nombre") String nombre, @RequestParam("ciudad") String ciudad){
		return service.ubicacionRestaurante(nombre, ciudad);
	}
	
	// localhost:9080/bajaRestaurante
	@PostMapping(value="/bajaRestaurante", produces = MediaType.APPLICATION_JSON_VALUE)
	public void bajaRestaurante(@RequestBody Restaurante restaurante) {
		service.bajaRestaurante(restaurante);
	}
	
	// localhost:9080/modificarRestaurante
	@PostMapping(value="/modificarRestaurante", produces = MediaType.APPLICATION_JSON_VALUE)
	public void modificarRestaurante(@RequestBody Restaurante restaurante) {
		service.modificarRestaurante(restaurante);
	}
	
	//localhost:9080/cogerIdPorRazonSocial
	@PostMapping(value="/cogerIdPorRazonSocial", produces = MediaType.APPLICATION_JSON_VALUE)
	public int cogerIdPorNombreCalleCiudad(@RequestParam("razonSocial") String razonSocial) {
		return service.cogerIdPorRazonSocial(razonSocial);
	}
	
	//localhost:9080/inicioSesion
	@PostMapping(value="/inicioSesion", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean comprobarCorreoYContra(@RequestBody Map<String, String> datos) {
	    String correo = datos.get("correo");
	    String contra = datos.get("contra");
	    return service.comprobarCorreoYContra(correo, contra);
	}
	
	//localhost:9080/idPorCorreo
	@PostMapping(value="/idPorCorreo", produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer cogerIdPorCorreo(@RequestParam("correo") String correo) {
		return service.cogerIdPorCorreo(correo);
	}
}
