package com.hosteleria.service;

import java.util.ArrayList;

import com.hosteleria.model.Producto;

public interface ProductoService {
	void crearProducto();
	void modificarProducto();
	void eliminarProducto();
	ArrayList<Producto> listaProductosPrecioMayor();
	ArrayList<Producto> listaProductosPrecioMeno();
}
