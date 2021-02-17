package com.village.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.village.entity.Personage;
import com.village.repository.PersonageRepository;

@Service
@Transactional
public class PersonageServiceImplements implements PersonageService {

	@Autowired
	private PersonageRepository repository;
	
	@Override
	public Map<String, String> save(Personage personage) {
		
		Boolean existingPersonage = false;
		List<Personage> allPersonage = repository.findAll();		
		String personageInsert = personage.getName().toUpperCase();
		
		for(Personage p : allPersonage) {			
			String personageDatabase  = p.getName().toUpperCase();									
			if(personageInsert.equals(personageDatabase)) {
				existingPersonage = true;
				break;
			}				
		}
		
		Map<String, String> objectMap = new HashMap<String, String>();
		
		if(existingPersonage) {
			
			objectMap.put("messageType", "fail");
			objectMap.put("mensage", "Erro. Personagem já existente.");
			
		} else {
			
			repository.save(personage);
			
			objectMap.put("messageType", "success");
			objectMap.put("mensage", "Personagem cadastrado com sucesso!");
			
		}
		return objectMap;		
	} // end save()

	
	@Override
	public Map<String, String> update(Personage personage) {
		
		repository.save(personage);
		
		Map<String, String> objectMap = new HashMap<String, String>();
		objectMap.put("messageType", "success");
		objectMap.put("message", "Personagem editado com sucesso!");
		
		return objectMap;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Personage findById(Long id) {
		return repository.getOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Personage> findAll() {
		return repository.findAll();
	}

}
