package com.hosteleria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hosteleria.dao.ProductoDao;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoDao dao;
	
}
