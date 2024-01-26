package com.hosteleria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hosteleria.model.Restaurante;

public interface RestauranteDao extends JpaRepository<Restaurante, Integer> {
	
	@Query(value="SELECT r.razon_social FROM restaurante r WHERE r.razon_social = :razonSocial", nativeQuery = true)
	public String comprobarExistenciaRestaurante(@Param("razonSocial") String razonSocial);
	
}
