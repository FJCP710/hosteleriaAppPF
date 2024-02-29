package com.hosteleria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosteleria.model.Promocion;

public interface PromocionDao extends JpaRepository<Promocion, Integer> {

}
