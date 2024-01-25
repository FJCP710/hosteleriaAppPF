package com.hosteleria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosteleria.model.Restaurante;

public interface RestauranteDao extends JpaRepository<Restaurante, Integer> {

}
