package com.hosteleria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hosteleria.model.Usuario;

public interface UsuariosDao extends JpaRepository<Usuario, Integer> {
	
	@Query(value="SELECT * FROM usuarios u WHERE u.usuario = :usuario OR u.correo = :correo", nativeQuery = true)
	public List<Usuario> comprobarAltaUsuario(@Param("usuario") String usuario, @Param("correo") String correo);
	
	@Query(value="SELECT u.nombre, u.apellido FROM usuarios u WHERE u.usuario = :usuario", nativeQuery = true)
	public List<String> buscarNombrePorUsuario(@Param("usuario") String usuario);
}
