package com.village.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.village.entity.Gifting;
import com.village.repository.GiftingRepository;

@Transactional
@Service
public class GiftingServiceImplements implements GiftingService {

	@Autowired
	private GiftingRepository giftingRepository;

	@Override
	public Map<String, String> save(Gifting gifting) {
		
		Boolean existingGifting = false;
		Long idPersonage = gifting.getPersonage().getId();
		Long idGift = gifting.getGift().getId();
		List<Gifting> allGifting = giftingRepository.findAll();
		
		for(Gifting g : allGifting) {
			if((idPersonage == g.getPersonage().getId()) && (idGift == g.getGift().getId())) {
				existingGifting = true;
				break;
			}
		}
		
		Map<String, String> objectMap = new HashMap<String, String>();
		
		if (existingGifting) {
			
			objectMap.put("messageType", "fail");
			objectMap.put("message", "Erro. Combinação já existe.");
			
		} else {
			
			giftingRepository.save(gifting);
			
			objectMap.put("messageType", "success");
			objectMap.put("message", "Combinação cadastrada com sucesso!");
			
		}
		return objectMap;
	}

	@Override
	public Map<String, String> update(Gifting gifting) {
		
		giftingRepository.save(gifting);
		
		Map<String, String> objectMap = new HashMap<String, String>();
		objectMap.put("messageType", "success");
		objectMap.put("message", "Combinação editada com sucesso!");
		
		return objectMap;
	}

	@Override
	public void delete(Long id) {
		giftingRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Gifting findById(Long id) {
		return giftingRepository.getOne(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Gifting> findAll() {
		return giftingRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Gifting> findByPersonageId(Long id) {
		return giftingRepository.findByPersonageId(id);
	}
	
}
