package com.hosteleria.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hosteleria.dao.PromocionDao;
import com.hosteleria.model.Promocion;

@Service
public class PromocionServiceImpl implements PromocionService {

	@Autowired
	PromocionDao dao;
	
	@Override
	public void crearPromocion(Promocion promocion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarPromocion(Promocion promocion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPromocion(Promocion promocion) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Promocion> listarPromocionesPorRestaurante() {
		// TODO Auto-generated method stub
		return null;
	}

}
