package com.hosteleria.service;

import java.time.LocalDate;
import java.time.Period;
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
	public Usuario buscarUsuario(int idUsuario) {
		Usuario usuario = dao.buscarUsuario(idUsuario);
		return usuario;
	}
	
	@Override
	public void eliminarUsuario(int idUsuario) {
		dao.deleteById(idUsuario);
		dao.flush();
	}
	
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

	@Override
	public boolean verificarEdad(int idUsuario) {
		LocalDate hoy = LocalDate.now();
		LocalDate fecNac = dao.verificarEdad(idUsuario);
		Period periodo = Period.between(fecNac, hoy);
		
		if(periodo.getYears() >= 18) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarUsuarioYContra(String usuario, String contra, String correo) {
	    Usuario user = dao.buscarUsuarioPorCorreo(correo);
	    
	    if(!usuario.isEmpty() && !usuario.isBlank() && usuario != null && !usuario.equals(user.getUsuario())) {
	    	dao.actualizarUsuarioYContra(usuario, user.getContra(), user.getId_usuario());
	    }
	    if(!contra.isEmpty() && !contra.isBlank() && contra != null && !contra.equals(user.getContra())) {
	    	dao.actualizarUsuarioYContra(user.getUsuario(), contra, user.getId_usuario());
	    }
	}

	@Override
	public boolean comprobarCorreoYContra(String correo, String contra) {
		if(dao.comprobarCorreoYContra(correo, contra) == true) {
			return true;
		} else {
			return false;
		}
	}
}
