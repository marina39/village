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
import com.village.entity.Gifting;
import com.village.entity.Personage;
import com.village.service.GiftService;
import com.village.service.GiftingService;
import com.village.service.PersonageService;

@Controller
@RequestMapping("/presenteando")
public class GiftingController {

	@Autowired
	private GiftingService giftingService;
	
	@Autowired
	private PersonageService personageService;
	
	@Autowired
	private GiftService giftService;
	
	@GetMapping("/cadastrar")
	public String register(Gifting gifting) {
		return "/gifting/register";
	}
	
	@PostMapping("/salvar")
	public String save(Gifting gifting, ModelMap model) {
		Map<String, String> result = giftingService.save(gifting);
		model.addAttribute(result.get("messageType"), result.get("message"));
		return list(model);
	}
	
	@GetMapping("/listar")
	public String list(ModelMap model) {
		model.addAttribute("allGifting", giftingService.findAll());
		return "/gifting/list";
	}
	
	@GetMapping("/excluir/{id}")
	private String delete(@PathVariable("id") Long id, ModelMap model) {
		giftingService.delete(id);
		return list(model);
	}
	
	@GetMapping("/buscar/personagem")
	public String findByPersonage(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("presenteando", giftingService.findByPersonageId(id));
		return "/gifting/list";
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
