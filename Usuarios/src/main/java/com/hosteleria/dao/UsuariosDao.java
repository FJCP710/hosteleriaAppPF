package com.hosteleria.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hosteleria.model.Usuario;

public interface UsuariosDao extends JpaRepository<Usuario, Integer> {
	
	@Query(value="SELECT * FROM usuarios u WHERE u.id_usuario = :idUsuario", nativeQuery = true)
	public Usuario buscarUsuario(@Param("idUsuario") int idUsuario);
	
	@Query(value="SELECT * FROM usuarios u WHERE u.usuario = :usuario OR u.correo = :correo", nativeQuery = true)
	public List<Usuario> comprobarAltaUsuario(@Param("usuario") String usuario, @Param("correo") String correo);
	
	@Query(value="SELECT u.nombre, u.apellido FROM usuarios u WHERE u.usuario = :usuario", nativeQuery = true)
	public List<String> buscarNombrePorUsuario(@Param("usuario") String usuario);
	
	@Query(value="SELECT u.fecha_nacimiento FROM usuarios u WHERE u.id_usuario = :idUsuario", nativeQuery = true)
	public LocalDate verificarEdad(@Param("idUsuario") int idUsuario);
	
	@Query(value="SELECT * FROM usuarios u WHERE u.correo = :correo", nativeQuery = true)
	public Usuario buscarUsuarioPorCorreo(@Param("correo") String correo);
	
	@Query(value="SELECT CASE WHEN EXISTS (SELECT * FROM usuarios u WHERE u.correo = :correo AND u.contra = :contra) THEN TRUE ELSE FALSE END", nativeQuery = true)
	public Long comprobarCorreoYContra(@Param("correo") String correo, @Param("contra") String contra);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE usuarios u SET u.usuario = :usuario, u.contra = :contra WHERE u.id_usuario = :idUsuario", nativeQuery = true)
	public void actualizarUsuarioYContra(@Param("usuario") String usuario, @Param("contra") String contra, @Param("idUsuario") int idUsuario);

	
}
