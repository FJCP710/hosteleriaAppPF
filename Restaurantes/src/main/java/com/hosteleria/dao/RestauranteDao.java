package com.hosteleria.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hosteleria.model.Restaurante;

public interface RestauranteDao extends JpaRepository<Restaurante, Integer> {
	
	@Query(value="SELECT COUNT(*) FROM restaurante r WHERE r.razon_social = :razonSocial", nativeQuery = true)
	public int comprobarExistenciaRestaurante(@Param("razonSocial") String razonSocial);
	
	@Query(value="SELECT * FROM restaurante r WHERE r.ciudad = :ciudad", nativeQuery = true)
	public ArrayList<Restaurante> listadoRestaurantePorCiudad(@Param("ciudad") String ciudad);
	
	@Query(value="SELECT * FROM restaurante r WHERE r.razon_social = :razonSocial", nativeQuery = true)
	public Restaurante buscarRestaurantePorRazonSocial(@Param("razonSocial") String razonSocial);
	
	@Query(value="SELECT * FROM restaurante r WHERE r.id_restaurante = :idRestaurante", nativeQuery = true)
	public Restaurante buscarRestaurantePorId(@Param("idRestaurante") String idRestaurante);
	
	@Query(value="SELECT CASE WHEN EXISTS (SELECT * FROM restaurante r WHERE r.correo = :correo AND r.contra = :contra) THEN TRUE ELSE FALSE END", nativeQuery = true)
	public Long comprobarCorreoYContra(@Param("correo") String correo, @Param("contra") String contra);
	
	@Query(value="SELECT r.id_restaurante FROM restaurante r WHERE r.razon_social = :razonSocial", nativeQuery = true)
	public int cogerIdPorRazonSocial(@Param("razonSocial") String razonSocial);
	
	@Query(value="SELECT r.id_restaurante FROM restaurante r WHERE r.correo = :correo", nativeQuery = true)
	public Integer cogerIdPorCorreo(@Param("correo") String correo);
}
