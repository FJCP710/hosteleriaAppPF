package com.hosteleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hosteleria.model.Usuario;
import com.hosteleria.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	// localhost:8080/usuario
	@PostMapping(value="usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public void comprobarAltaUsuario(@RequestBody Usuario usuario) {
		service.comprobarAltaUsuario(usuario);
	}
	
}
