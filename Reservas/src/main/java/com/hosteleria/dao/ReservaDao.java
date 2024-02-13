package com.hosteleria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosteleria.model.Reserva;

public interface ReservaDao extends JpaRepository<Reserva, Integer> {
	
}
