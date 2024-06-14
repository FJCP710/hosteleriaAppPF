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
		int comprobarPromocion = dao.comprobarExistenciaPromocion(promocion.getIdRestaurante(), promocion.getIdProducto());
		
		if(comprobarPromocion == 0) {
			dao.saveAndFlush(promocion);
		}
		
	}

	@Override
	public void modificarPromocion(Promocion promocion) {
		Promocion pro = dao.buscarPromocion(promocion.getIdRestaurante(), promocion.getIdProducto());
		
		if(pro != null) {
			if(promocion.getIdProducto() == pro.getIdProducto() && promocion.getIdRestaurante() == pro.getIdRestaurante()) {
				
				if(promocion.getPorcentaje() != pro.getPorcentaje()) {
					pro.setPorcentaje(promocion.getPorcentaje());
					dao.save(pro);
				}
				
				if(promocion.getPrecioMin() != pro.getPrecioMin()) {
					pro.setPrecionMin(promocion.getPrecioMin());
					dao.save(pro);
				}
			}
		}
		
	}

	@Override
	public void eliminarPromocion(Promocion promocion) {
		Promocion pro = dao.buscarPromocion(promocion.getIdRestaurante(), promocion.getIdProducto());
		
		if(promocion.getIdProducto() == pro.getIdProducto() && promocion.getIdRestaurante() == pro.getIdRestaurante()) {
			dao.deleteById(pro.getIdProducto());
			dao.flush();
		}
		
	}

	@Override
	public ArrayList<Promocion> listarPromocionesPorRestaurante(int idRestaurante) {
		ArrayList<Promocion> promocion = dao.listarPromocionesPorRestaurante(idRestaurante);
		
		for (Promocion p : promocion) {
			if(p.getPorcentaje() == null) {
				p.setPorcentaje(0.0);
			}
			if(p.getPrecioMin() == null) {
				p.setPrecionMin(0.0);
			}
		}
		
		return promocion;
	}

	

}