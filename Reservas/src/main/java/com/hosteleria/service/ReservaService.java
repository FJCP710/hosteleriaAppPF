package com.hosteleria.service;

import java.util.ArrayList;

import com.hosteleria.model.Reserva;

public interface ReservaService {
	
	void altaReserva(Reserva reserva);
	ArrayList<Reserva> listarReservasPorRestaurante(String restaurante, String ciudad);
	ArrayList<Reserva> listarReservasPorUsuario(String usuario, String correo);
	void eliminarReserva(Reserva reserva);
	void modificarReserva(Reserva reserva);
	
}
