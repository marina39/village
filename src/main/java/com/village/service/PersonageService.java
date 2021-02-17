package com.village.service;

import java.util.List;
import java.util.Map;

import com.village.entity.Personage;

public interface PersonageService {
	
	Map<String, String> save(Personage personage);
	
	Map<String, String> update(Personage personage);
	
	void delete(Long id);
	
	Personage findById(Long id);
	
	List<Personage> findAll();

}
