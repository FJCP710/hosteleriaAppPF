package com.hosteleria.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hosteleria.dao.ReservaDao;
import com.hosteleria.model.Reserva;

public class RestauranteServiceImpl implements ReservaService{

	@Autowired
	ReservaDao dao;
	
	@Override
	public void altaReserva(Reserva reserva) {		int comrpobarReserva = dao.comprobarExistenciaReserva(reserva.getIdUsuario(), reserva.getIdRestaurante(), reserva.getFecha());
		
		if(comrpobarReserva == 0) {
			dao.saveAndFlush(reserva);
		}
	}

	@Override
	public ArrayList<Reserva> listarReservasPorRestaurante(String restaurante, String ciudad) {		int idRest = dao.buscarIdRestaurantePorCiudad(restaurante, ciudad);
		ArrayList<Reserva> reservasRestaurante = dao.listarReservasPorRestaurante(idRest);
		
		return reservasRestaurante;
	}

	@Override
	public ArrayList<Reserva> listarReservasPorUsuario(String usuario, String correo) {		int idUsu = dao.buscarIdUsuario(usuario, correo);
		ArrayList<Reserva> reservasUsuario = dao.listarReservasPorUsuario(idUsu);
		
		return reservasUsuario;
	}

	@Override
	public void eliminarReserva(Reserva reserva) {		Reserva res = dao.buscarReserva(reserva.getIdUsuario(), reserva.getIdRestaurante(), reserva.getFecha());
		
		if(dao.comprobarExistenciaReserva(reserva.getIdUsuario(), reserva.getIdRestaurante(), reserva.getFecha()) == 1) {
			dao.delete(res);
			dao.flush();
		}
	}

	@Override
	public void modificarReserva(Reserva reserva) {		Reserva res = dao.buscarReserva(reserva.getIdUsuario(), reserva.getIdRestaurante(), reserva.getFecha());
		
		if(!res.getNombreReserva().equals(reserva.getNombreReserva())) {
			res.setNombreReserva(reserva.getNombreReserva());
			dao.save(res);
		}
		if(res.getNumPersonas()!=reserva.getNumPersonas()) {
			res.setNumPersonas(reserva.getNumPersonas());
			dao.save(res);
		}
		dao.flush();				
	}

}
