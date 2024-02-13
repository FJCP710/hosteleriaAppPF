package com.hosteleria.service;

import java.util.ArrayList;

import com.hosteleria.model.Reserva;

public interface ReservaService {
	
	void altaReserva(Reserva reserva);
	ArrayList<Reserva> listarReservasPorRestaurante();
	ArrayList<Reserva> listarReservasPorUsuario();
	int eliminarReserva(Reserva reserva);
	void modificarReserva(Reserva reserva);
	
}
