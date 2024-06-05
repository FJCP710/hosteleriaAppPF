package com.hosteleria.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hosteleria.dao.ReservaDao;
import com.hosteleria.model.Reserva;

@Service
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	ReservaDao dao;
	
	LocalDateTime hoy = LocalDateTime.now();
	
	@Override
	public void altaReserva(Reserva reserva) {		int comrpobarReserva = dao.comprobarExistenciaReserva(reserva.getIdUsuario(), reserva.getIdRestaurante(), reserva.getFecha());
		
		if(comrpobarReserva == 0) {
			dao.saveAndFlush(reserva);
		}
	}

	@Override
	public ArrayList<Reserva> listarReservasPorRestaurante(String restaurante, String ciudad) {		Integer idRest = dao.buscarIdRestaurantePorCiudad(restaurante, ciudad);
		ArrayList<Reserva> reservasRestaurante = new ArrayList<Reserva>();
		
		if(idRest != null && idRest != 0) {
			reservasRestaurante = dao.listarReservasPorRestaurante(idRest);
		} else {
			return null;
		}
		
		return reservasRestaurante;
	}

	@Override
	public ArrayList<Reserva> listarReservasPorUsuario(int idUsuario) {
				
		return dao.listarReservasPorUsuario(idUsuario);
	}

	@Override
	public void eliminarReserva(Reserva reserva) {
		int comrpobarReserva = dao.comprobarExistenciaReserva(reserva.getIdUsuario(), reserva.getIdRestaurante(), reserva.getFecha());
		
		if(comrpobarReserva != 0) {
			dao.deleteById(reserva.getIdReserva());
		}
		dao.flush();
	}

	@Override
	public void modificarReserva(Reserva reserva) {
				ArrayList<Reserva> res = dao.buscarReserva(reserva.getIdUsuario(), reserva.getIdRestaurante());
		
		if(res.size() != 0) {
			if(res.size() == 1) {
				modificacionTamano1(res, reserva);
			} else {
				modificacionTamano2(res, reserva);
			}
		}
		
		dao.flush();				
	}
	
	public ArrayList<Reserva> modificacionTamano1(ArrayList<Reserva> res, Reserva reserva){
		LocalDate fechaReserva = reserva.getFecha().toLocalDate();
		LocalTime horaReseva = reserva.getFecha().toLocalTime();
		for (Reserva r : res) {
			LocalDate fechaRe= r.getFecha().toLocalDate();
			LocalTime horaRe = r.getFecha().toLocalTime();
			
			if(!fechaReserva.equals(fechaRe) || !horaReseva.equals(horaRe)) {
				r.setFecha(reserva.getFecha());
				dao.save(r);
			}
			
			if(reserva.getNumPersonas() != r.getNumPersonas()) {
				r.setNumPersonas(reserva.getNumPersonas());
				dao.save(r);
			}
			
			if(reserva.getNombreReserva() != r.getNombreReserva()) {
				r.setNombreReserva(reserva.getNombreReserva());
				dao.save(r);
			}
		}
		return res;
	}
	
	public ArrayList<Reserva> modificacionTamano2(ArrayList<Reserva> res, Reserva reserva){
		long fecha1;
		long fecha2;
		
		if(res.size() == 2) {
			for(int i = 0; res.size()>i; i++) {
				fecha1 = Math.abs(Duration.between(hoy, res.get(i).getFecha()).toSeconds());
				fecha2 = Math.abs(Duration.between(hoy, res.get(i+1).getFecha()).toSeconds());
				
				if(fecha1 < fecha2) {
					res.remove(i+1);
					modificacionTamano1(res, reserva);
				} else {
					res.remove(i);
					modificacionTamano1(res, reserva);
					i--;
				}
			}
		}
		return res;
	}

}
