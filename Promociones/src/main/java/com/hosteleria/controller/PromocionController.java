package com.hosteleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hosteleria.service.PromocionService;

@RestController
public class PromocionController {

	@Autowired
	PromocionService service;
	
}
