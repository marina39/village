package com.village.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.village.entity.Gift;
import com.village.entity.Combination;
import com.village.entity.Personage;
import com.village.service.GiftService;
import com.village.service.CombinationService;
import com.village.service.PersonageService;

@Controller
@RequestMapping("/presenteando")
public class CombinationController {

	@Autowired
	private CombinationService combinationService;
	
	@Autowired
	private PersonageService personageService;
	
	@Autowired
	private GiftService giftService;
	
	@GetMapping("/cadastrar")
	public String register(Combination combination) {
		return "/combination/register";
	}
	
	@PostMapping("/salvar")
	public String save(Combination combination, ModelMap model) {
		Map<String, String> result = combinationService.save(combination);
		model.addAttribute(result.get("messageType"), result.get("message"));
		return list(model);
	}
	
	@GetMapping("/listar")
	public String list(ModelMap model) {
		model.addAttribute("allCombination", combinationService.findAll());
		return "/combination/list";
	}
	
	@GetMapping("/excluir/{id}")
	private String delete(@PathVariable("id") Long id, ModelMap model) {
		combinationService.delete(id);
		return list(model);
	}
	
	@GetMapping("/buscar/personagem")
	public String findByPersonage(@RequestParam("id") Long id, ModelMap model) {
		List<Combination> combinations = combinationService.findByPersonageId(id);
		model.addAttribute("allCombination", combinations);
		return "/combination/list";
	}
	
	@GetMapping("/buscar/presente")
	public String findByGift(@RequestParam("id") Long id, ModelMap model) {
		List<Combination> combinations = combinationService.findByGiftId(id);
		model.addAttribute("allCombination", combinations);
		return "/combination/list";
	}
	
	@ModelAttribute("allPersonage")
	public List<Personage> findAllPersonage() {
		return personageService.findAll();
	}
	
	@ModelAttribute("allGift")
	public List<Gift> findAllGift(){
		return giftService.findAll();
	}
	
}
