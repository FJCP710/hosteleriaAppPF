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
	public void crearProducto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarProducto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarProducto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Producto> listaProductosPrecioMayor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Producto> listaProductosPrecioMeno() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
