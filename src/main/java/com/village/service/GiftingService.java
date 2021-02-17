package com.village.service;

import java.util.List;
import java.util.Map;

import com.village.entity.Gifting;

public interface GiftingService {
	
	Map<String, String> save(Gifting gifting);
	
	Map<String, String> update(Gifting gifting);
	
	void delete(Long id);
	
	Gifting findById(Long id);
	
	List<Gifting> findAll();
	
	List<Gifting> findByPersonageId(Long id);

}
