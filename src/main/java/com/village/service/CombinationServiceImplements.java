package com.village.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.village.entity.Combination;
import com.village.repository.CombinationRepository;

@Transactional
@Service
public class CombinationServiceImplements implements CombinationService {

	@Autowired
	private CombinationRepository combinationRepository;

	@Override
	public Map<String, String> save(Combination combination) {
		
		Boolean existingCombination = false;
		Long idPersonage = combination.getPersonage().getId();
		Long idGift = combination.getGift().getId();
		List<Combination> allCombination = combinationRepository.findAll();
		
		for(Combination g : allCombination) {
			if((idPersonage == g.getPersonage().getId()) && (idGift == g.getGift().getId())) {
				existingCombination = true;
				break;
			}
		}
		
		Map<String, String> objectMap = new HashMap<String, String>();
		
		if (existingCombination) {
			
			objectMap.put("messageType", "fail");
			objectMap.put("message", "Erro. Combinação já existe.");
			
		} else {
			
			combinationRepository.save(combination);
			
			objectMap.put("messageType", "success");
			objectMap.put("message", "Combinação cadastrada com sucesso!");
			
		}
		return objectMap;
	}

	@Override
	public Map<String, String> update(Combination combination) {
		
		combinationRepository.save(combination);
		
		Map<String, String> objectMap = new HashMap<String, String>();
		objectMap.put("messageType", "success");
		objectMap.put("message", "Combinação editada com sucesso!");
		
		return objectMap;
	}

	@Override
	public void delete(Long id) {
		combinationRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Combination findById(Long id) {
		return combinationRepository.getOne(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Combination> findAll() {
		return combinationRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Combination> findByPersonageId(Long id) {
		return combinationRepository.findByPersonageId(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Combination> findByGiftId(Long id) {
		return combinationRepository.findByGiftId(id);
	}
	
	
	
}
