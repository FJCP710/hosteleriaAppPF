package com.hosteleria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hosteleria.dao.RestauranteDao;
import com.hosteleria.model.Restaurante;

@Service
public class RestauranteServiceImpl implements RestauranteService {

	@Autowired
	RestauranteDao dao;
	
	@Override
	public void altaRestaurante(Restaurante restaurante) {
		String razonSocial = dao.comprobarExistenciaRestaurante(restaurante.getRazonSocial());
		
 		if(!restaurante.getRazonSocial().equals(razonSocial) && !razonSocial.isBlank() && !razonSocial.isEmpty() && razonSocial != null) {
 			dao.saveAndFlush(restaurante);
 		}
	}

}
