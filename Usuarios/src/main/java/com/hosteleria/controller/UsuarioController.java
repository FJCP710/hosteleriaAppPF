package com.hosteleria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hosteleria.model.Usuario;
import com.hosteleria.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	// localhost:8080/usuario
	@PostMapping(value="/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public void comprobarAltaUsuario(@RequestBody Usuario usuario) {
		service.comprobarAltaUsuario(usuario);
	}
	
	// localhost:8080/nombreUsuario
	@GetMapping(value="/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> buscarNombrePorUsuario(@RequestParam("usuario") String usuario) {
		return service.buscarNombrePorUsuario(usuario);
	}
	
}
