package com.hosteleria.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hosteleria.model.Producto;

public interface ProductoDao extends JpaRepository<Producto, Integer> {

	@Query(value="SELECT COUNT(*) FROM producto p WHERE p.nombre = :nombre AND p.precio = :precio", nativeQuery = true)
	public int comprobarExistenciaProducto(@Param("nombre") String nombre, @Param("precio") double precio);	
	
	@Query(value="SELECT * FROM producto p WHERE p.nombre = :nombre AND p.precio = :precio AND p.dimension = :dimension", nativeQuery = true)
	public Producto buscarProducto(@Param("nombre") String nombre, @Param("precio") double precio, @Param("dimension") String dimension);
	
	@Query(value="SELECT * FROM producto p WHERE p.precio >= :precio BY p.precio DESC", nativeQuery = true)
	public ArrayList<Producto> productosMayores(@Param("precio") double precio);
	
	@Query(value="SELECT * FROM producto p WHERE p.precio <= :precio BY p.precio ASC", nativeQuery = true)
	public ArrayList<Producto> productosMenores(@Param("precio") double precio);
	
	@Query(value="SELECT * FROM producto p WHERE p.nombre = :nombre", nativeQuery = true)
	public Integer cogerIdPorNombre(@Param("nombre") String nombre);
	
	@Query(value="SELECT * FROM producto p WHERE p.id_producto = :idProducto", nativeQuery = true)
	public Producto cogerProductoPorId(@Param("idProducto") int idProducto);
}
