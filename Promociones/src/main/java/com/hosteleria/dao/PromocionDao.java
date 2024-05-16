package com.hosteleria.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hosteleria.model.Promocion;

public interface PromocionDao extends JpaRepository<Promocion, Integer> {
	
	@Query(value="SELECT COUNT (*) FROM promocion p WHERE p.id_restaurante = :idRestaurante AND p.id_producto = :idProducto", nativeQuery = true)
	public int comprobarExistenciaPromocion(@Param("idRestaurante") int idRestaurante, @Param("idProducto") int idProducto);
	
	@Query(value="SELECT * FROM promocion p WHERE p.id_restaurante = :idRestaurante AND p.id_producto = :idProducto", nativeQuery = true)
	public Promocion buscarPromocion(@Param("idRestaurante") int idRestaurante, @Param("idProducto") int idProducto);
	
	@Query(value="SELECT * FROM promocion p WHERE p.id_restaurante = :idRestaurante", nativeQuery = true)
	public ArrayList<Promocion> listarPromocionesPorRestaurante(@Param("idRestaurante") int idRestaurante);
}
