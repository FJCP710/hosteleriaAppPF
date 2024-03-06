package com.hosteleria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosteleria.model.Producto;

public interface ProductoDao extends JpaRepository<Producto, Integer> {

}
