package com.hosteleria.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hosteleria.model.Reserva;
import com.hosteleria.service.ReservaService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ReservaController {
	
	@Autowired
	ReservaService service;
	
	// localhost:9090/crearReserva
	@PostMapping(value="/crearReserva")
	public void crearReserva(@RequestBody Reserva reserva) {
		service.altaReserva(reserva);
	}
	
	// localhost:9090/listarPorRestaurante
	@GetMapping(value="/listarPorRestaurante", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Reserva> listarPorRestaurante(@RequestParam("restaurante") String restaurante, @RequestParam("ciudad") String ciudad){
		return service.listarReservasPorRestaurante(restaurante, ciudad);
	}
	
	// localhost:9090/listarPorUsuario
	@PostMapping(value="/listarPorUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Reserva> listarPorUsuario(@RequestParam("idUsuario") int idUsuario){
		return service.listarReservasPorUsuario(idUsuario);
	}
	
	
	// localhost:9090/eliminarReserva
	@PostMapping(value="/eliminarReserva")
	public void eliminarReserva(@RequestBody Reserva reserva) {
		service.eliminarReserva(reserva);
	}
	
	
	// localhost:9090/modificarReserva
	@PostMapping(value="/modificarReserva")
	public void modificarReserva(@RequestBody Reserva reserva) {
		service.modificarReserva(reserva);
	}
	
}
