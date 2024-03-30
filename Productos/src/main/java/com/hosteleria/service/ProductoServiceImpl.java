package com.hosteleria.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hosteleria.dao.ProductoDao;
import com.hosteleria.model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoDao dao;

	@Override
	public void crearProducto(Producto producto) {
		int comprobarProducto = dao.comprobarExistenciaProducto(producto.getNombre(), producto.getPrecio());
		
		if(comprobarProducto == 0) {
			dao.saveAndFlush(producto);
		}
		
	}

	@Override
	public void modificarProducto(Producto producto) {
		int comprobarProducto = dao.comprobarExistenciaProducto(producto.getNombre(), producto.getPrecio());
		
		if(comprobarProducto != 0) {
			Producto pro = dao.buscarProducto(producto.getNombre(), producto.getPrecio(), producto.getDimension());
			
			if(!producto.getNombre().equals(pro.getNombre())) {
				pro.setNombre(producto.getNombre());
				dao.save(pro);
			}
			
			if(producto.getPrecio() != pro.getPrecio()) {
				pro.setPrecio(producto.getPrecio());
				dao.save(pro);
			}
			
			if(!producto.getDimension().equals(pro.getDimension())) {
				pro.setDimension(producto.getDimension());
				dao.save(pro);
			}
			dao.flush();
		}
		
	}

	@Override
	public void eliminarProducto(Producto producto) {
		int comprobarProducto = dao.comprobarExistenciaProducto(producto.getNombre(), producto.getPrecio());
		
		if(comprobarProducto != 0) {
			Producto pro = dao.buscarProducto(producto.getNombre(), producto.getPrecio(), producto.getDimension());
			
			if(producto.getNombre().equals(pro.getNombre()) && producto.getPrecio() == pro.getPrecio() && producto.getDimension().equals(pro.getDimension())) {
				dao.deleteById(pro.getIdProducto());
				dao.flush();
			}
		}
	}

	@Override
	public ArrayList<Producto> listaProductosPrecioMayor(double precio) {
		
		return dao.productosMayores(precio);
	}

	@Override
	public ArrayList<Producto> listaProductosPrecioMeno(double precio) {
		
		return dao.productosMenores(precio);
	}
	
}
