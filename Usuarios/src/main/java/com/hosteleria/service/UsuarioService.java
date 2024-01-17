package com.hosteleria.service;

import java.util.List;

import com.hosteleria.model.Usuario;

public interface UsuarioService {
	
	void comprobarAltaUsuario(Usuario usuario);
	List<String> buscarNombrePorUsuario(String user);
}
