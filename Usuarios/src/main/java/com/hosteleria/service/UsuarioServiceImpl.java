package com.hosteleria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hosteleria.dao.UsuariosDao;
import com.hosteleria.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuariosDao dao;
	
	@Override
	public void comprobarAltaUsuario(Usuario usuario) {
		if(dao.comprobarAltaUsuario(usuario.getUsuario(), usuario.getCorreo()).size() == 0) {
			dao.saveAndFlush(usuario);
		}
	}

	@Override
	public List<String> buscarNombrePorUsuario(String usuario) {
		List<String> nombres = dao.buscarNombrePorUsuario(usuario);
		return nombres;
	}

}
