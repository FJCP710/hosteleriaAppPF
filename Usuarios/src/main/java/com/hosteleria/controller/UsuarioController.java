package com.hosteleria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hosteleria.model.Usuario;
import com.hosteleria.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	//localhost:8080/borrarUsuario
	@PostMapping(value="/borrarUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminarUsuario(@RequestParam("idUsuario") int idUsuario) {
		service.eliminarUsuario(idUsuario);
	}
	
	// localhost:8080/usuario
	@GetMapping(value="/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario buscarUsuario(@RequestParam("idUsuario") int idUsuario) {
		return service.buscarUsuario(idUsuario);
	}
	
	// localhost:8080/crearUsuario
	@PostMapping(value="/crearUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public void comprobarAltaUsuario(@RequestBody Usuario usuario) {
		service.comprobarAltaUsuario(usuario);
	}
	
	// localhost:8080/nombreUsuario
	@GetMapping(value="/nombreUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> buscarNombrePorUsuario(@RequestParam("usuario") String usuario) {
		return service.buscarNombrePorUsuario(usuario);
	}
	
	// localhost:8080/edad
	@GetMapping(value="/edad")
	public boolean verificarEdad(@RequestParam("idUsuario") int idUsuario) {
		return service.verificarEdad(idUsuario);
	}
	
	//localhost:8080/modificarContra
	@PostMapping(value="/modificar")
	public void modificar(@RequestParam("usuario") String usuario, @RequestParam("contra") String contra, @RequestParam("correo") String correo) {
		service.modificarUsuarioYContra(usuario, contra, correo);
	}

}
