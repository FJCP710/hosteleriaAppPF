package com.hosteleria.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hosteleria.model.Reserva;

public interface ReservaDao extends JpaRepository<Reserva, Integer> {
	
	@Query(value="SELECT COUNT(*) FROM reserva r WHERE r.id_usuario = :idUsuario AND r.id_restaurante = :r.idRestaurante AND r.fecha = :fecha", nativeQuery = true)
	public int comprobarExistenciaReserva(@Param("idUsuario") int idUsuario, @Param("idRestaurante") int idRestaurante, @Param("fecha") Date fecha);
	
	@Query(value="SELECT * FROM reserva r WHERE r.id_restaurante = :idRestaurante", nativeQuery = true)
	public ArrayList<Reserva> listarReservasPorRestaurante(@Param("idRestaurante") int idRestaurante);
	
	@Query(value = "SELECT r.id_restaurante FROM restaurante r WHERE r.nombre_comercial = :nombre AND r.ciudad = :ciudad", nativeQuery = true)
	public int buscarIdRestaurantePorCiudad(@Param("nombre") String nombre, @Param("ciudad") String ciudad);
	
	@Query(value="SELECT * FROM reserva r WHERE r.id_usuario = :idUsuario", nativeQuery = true)
	public ArrayList<Reserva> listarReservasPorUsuario(@Param("idUsuario") int idUsuario);
	
	@Query(value = "SELECT u.id_usuario FROM usuarios u WHERE u.usuario = :usuario AND u.correo = :correo", nativeQuery = true)
	public int buscarIdUsuario(@Param("usuario") String usuario, @Param("correo") String correo);
	
	@Query(value="SELECT COUNT(*) FROM reserva r WHERE r.id_usuario = :idUsuario AND r.id_restaurante = :r.idRestaurante AND r.fecha = :fecha", nativeQuery = true)
	public Reserva buscarReserva(@Param("idUsuario") int idUsuario, @Param("idRestaurante") int idRestaurante, @Param("fecha") Date fecha);
	
}
