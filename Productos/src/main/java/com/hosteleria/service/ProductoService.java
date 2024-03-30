package com.hosteleria.service;

import java.util.ArrayList;

import com.hosteleria.model.Producto;

public interface ProductoService {
	void crearProducto(Producto producto);
	void modificarProducto(Producto producto);
	void eliminarProducto(Producto producto);
	ArrayList<Producto> listaProductosPrecioMayor(double precio);
	ArrayList<Producto> listaProductosPrecioMeno(double precio);
}
