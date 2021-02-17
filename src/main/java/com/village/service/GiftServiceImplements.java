package com.village.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.village.entity.Gift;
import com.village.repository.GiftRepository;

@Service
@Transactional
public class GiftServiceImplements implements GiftService {

	@Autowired
	private GiftRepository repository;
	
	@Override
	public Map<String, String> save(Gift gift) {
		
		Boolean existingGift = false;
		List<Gift> allGift = repository.findAll();
		String giftInser = gift.getName().toUpperCase();
		
		for(Gift g : allGift) {
			String giftDatabase = g.getName().toUpperCase();
			if(giftInser.equals(giftDatabase)) {
				existingGift = true;
				break;
			}
		}
		
		Map<String, String> objectMap = new HashMap<String, String>();
		
		if(existingGift) {
			
			objectMap.put("messageType", "fail");
			objectMap.put("message", "Erro. Presente já existente.");
			
		} else {
			
			repository.save(gift);
			
			objectMap.put("messageType", "success");
			objectMap.put("message", "Presente inserido com sucesso!");
			
		}
		
		return objectMap;
	} // end save()

	@Override
	public Map<String, String> update(Gift gift) {
		
		repository.save(gift);
		
		Map<String, String> objectMap = new HashMap<String, String>();
		objectMap.put("messageType", "success");
		objectMap.put("message", "Presente editado com sucesso!");
		
		return objectMap;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Gift findById(Long id) {
		return repository.getOne(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Gift> findAll() {
		return repository.findAll();
	}

}
