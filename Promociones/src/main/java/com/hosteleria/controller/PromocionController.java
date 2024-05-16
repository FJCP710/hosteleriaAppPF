package com.hosteleria.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hosteleria.model.Promocion;
import com.hosteleria.service.PromocionService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class PromocionController {

	@Autowired
	PromocionService service;
	
	@PostMapping(value="/crearPromocion")
	public void crearPromocion(@RequestBody Promocion promocion) {
		service.crearPromocion(promocion);
	}
	
	@PostMapping(value="/modificarPromocion")
	public void modificarPromocion(@RequestBody Promocion promocion) {
		service.modificarPromocion(promocion);
	}
	
	@PostMapping(value="/eliminarPromocion")
	public void eliminarPromocion(@RequestBody Promocion promocion) {
		service.eliminarPromocion(promocion);
	}
	
	@PostMapping(value="/listarPromocionesPorRestaurante")
	public ArrayList<Promocion> listarPromocionesPorRestaurante(@RequestBody int idRestaurante) {
		return service.listarPromocionesPorRestaurante(idRestaurante);
	}
}
