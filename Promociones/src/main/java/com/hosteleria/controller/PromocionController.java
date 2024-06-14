package com.hosteleria.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hosteleria.model.Promocion;
import com.hosteleria.service.PromocionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PromocionController {

	@Autowired
	PromocionService service;
	
	@PostMapping(value="/crearPromocion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crearPromocion(@RequestBody Promocion promocion) {
		service.crearPromocion(promocion);
		return ResponseEntity.ok("Promoción creado con éxito");
	}
	
	@PostMapping(value="/modificarPromocion", produces = MediaType.APPLICATION_JSON_VALUE)
	public void modificarPromocion(@RequestBody Promocion promocion) {
		service.modificarPromocion(promocion);
	}
	
	@PostMapping(value="/eliminarPromocion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarPromocion(@RequestBody Promocion promocion) {
	    try {
	        service.eliminarPromocion(promocion);
	        return new ResponseEntity<>("Promoción eliminada con éxito", HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Error al eliminar promoción", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
	@PostMapping(value="/listarPromocionesPorRestaurante", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Promocion> listarPromocionesPorRestaurante(@RequestParam int idRestaurante) {
		return service.listarPromocionesPorRestaurante(idRestaurante);
	}
}
