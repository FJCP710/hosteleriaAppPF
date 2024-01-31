package com.hosteleria.service;

import java.util.ArrayList;

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

	@Override
	public ArrayList<Restaurante> listadoRestaurantes(String ciudad) {
		return dao.listadoRestaurantePorCiudad(ciudad);
	}

	@Override
	public ArrayList<Restaurante> listadoRestaurantesPorCalle(String ciudad, String calle) {
		ArrayList<Restaurante> restaurantesCiudad = dao.listadoRestaurantePorCiudad(ciudad);
		ArrayList<Restaurante> restaurantesCalle = new ArrayList<Restaurante>();
		
		for(int i = 0; i < restaurantesCiudad.size(); i++) {
			if(restaurantesCiudad.get(i).getCalle().equals(calle)) {
				restaurantesCalle.add(restaurantesCiudad.get(i));
			}
		}
		
		return restaurantesCalle;
	}

	@Override
	public String ubicacionRestaurante(String nombre, String ciudad) {
		ArrayList<Restaurante> restaurantesCiudad = dao.listadoRestaurantePorCiudad(ciudad);
		String ub = null;
		
		for(Restaurante ubi : restaurantesCiudad) {
			if(ubi.getNombreComercial().equals(nombre)) {
				ub = ubi.getCalle()+" "+ubi.getNumero()+", "+ubi.getCiudad();
			}
		}
		
		return ub;
	}

}
