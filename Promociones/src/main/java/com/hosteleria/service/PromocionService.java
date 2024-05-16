package com.hosteleria.service;

import java.util.ArrayList;

import com.hosteleria.model.Promocion;

public interface PromocionService {
	void crearPromocion(Promocion promocion);
	void modificarPromocion(Promocion promocion);
	void eliminarPromocion(Promocion promocion);
	ArrayList<Promocion> listarPromocionesPorRestaurante(int idRestaurante);
}
