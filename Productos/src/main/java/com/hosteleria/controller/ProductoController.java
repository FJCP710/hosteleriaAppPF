package com.hosteleria.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hosteleria.model.Producto;
import com.hosteleria.service.ProductoService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ProductoController {

	@Autowired
	ProductoService service;
	
	// localhost:9060/crearProducto
	@PostMapping(value="/crearProducto")
	public void crearProducto(@RequestBody Producto producto) {
		service.crearProducto(producto);
	}
	
	// localhost:9060/modificarProducto
	@PostMapping(value="/modificarProducto")
	public void modificarProducto(@RequestBody Producto producto) {
		service.modificarProducto(producto);
	}
	
	// localhost:9060/eliminarProducto
	@PostMapping(value="/eliminarProducto")
	public void eliminarProducto(@RequestBody Producto producto) {
		service.eliminarProducto(producto);
	}
	
	// localhost:9060/listaProductosPrecioMayor
	@GetMapping(value="/listaProductosPrecioMayor", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Producto> listaProductosPrecioMayor (@RequestParam("precio") double precio){
		return service.listaProductosPrecioMayor(precio);
	}
	
	// localhost:9060/listaProductosPrecioMenor
	@GetMapping(value="/listaProductosPrecioMenor", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Producto> listaProductosPrecioMenor (@RequestParam("precio") double precio){
		return service.listaProductosPrecioMeno(precio);
	}
}
