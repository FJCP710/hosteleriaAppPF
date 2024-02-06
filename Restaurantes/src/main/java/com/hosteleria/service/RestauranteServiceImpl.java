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
		int existeRazon = dao.comprobarExistenciaRestaurante(restaurante.getRazonSocial());
		
		if(existeRazon == 0) {
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

	@Override
	public void bajaRestaurante(Restaurante restaurante) {
		
		Restaurante res = dao.buscarRestaurantePorRazonSocial(restaurante.getRazonSocial());
		String ubiRestaurante = restaurante.getCalle()+" "+restaurante.getNumero()+", "+restaurante.getCiudad();
		
		
		if(res != null) {
			String ubiRes = ubicacionRestaurante(res.getNombreComercial(), res.getCiudad());
			
			if(restaurante.getRazonSocial().equals(res.getRazonSocial()) && restaurante.getNombreComercial().equals(res.getNombreComercial())) {
				if(ubiRes.equals(ubiRestaurante) && restaurante.getCorreo().equals(res.getCorreo())) {
					dao.deleteById(res.getId_restaurante());
					dao.flush();
				}
			}
		}
	}
}
