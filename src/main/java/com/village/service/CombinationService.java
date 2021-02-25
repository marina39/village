package com.village.service;

import java.util.List;
import java.util.Map;

import com.village.entity.Combination;

public interface CombinationService {
	
	Map<String, String> save(Combination combination);
	
	Map<String, String> update(Combination combination);
	
	void delete(Long id);
	
	Combination findById(Long id);
	
	List<Combination> findAll();
	
	List<Combination> findByPersonageId(Long id);
	
	List<Combination> findByGiftId(Long id);

}
