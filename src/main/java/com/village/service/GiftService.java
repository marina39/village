package com.village.service;

import java.util.List;
import java.util.Map;

import com.village.entity.Gift;

public interface GiftService {
	
	Map<String, String> save(Gift gift);
	
	Map<String, String> update(Gift gift);
	
	void delete(Long id);
	
	Gift findById(Long id);
	
	List<Gift> findAll();

}
