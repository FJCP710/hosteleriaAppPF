package com.hosteleria.service;

import java.util.List;

import com.hosteleria.model.Usuario;

public interface UsuarioService {
	
	Usuario buscarUsuario(int idUsuario);
	void eliminarUsuario(int idUsuario);
	void comprobarAltaUsuario(Usuario usuario);
	List<String> buscarNombrePorUsuario(String user);
	boolean verificarEdad(int idUsuario);
	void modificarUsuarioYContra(String usuario, String contra, String correo);
	boolean comprobarCorreoYContra(String correo, String contra);
	Integer cogerIdPorCorreo(String correo);
}
