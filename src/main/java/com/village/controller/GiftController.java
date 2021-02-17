package com.village.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.village.entity.Gift;
import com.village.service.GiftService;

@Controller
@RequestMapping("/presentes")
public class GiftController {
	
	@Autowired
	GiftService giftService;
	
	@GetMapping("/cadastrar")
	private String register(Gift gift) {
		return "/gift/register";
	}
	
	@PostMapping("/salvar")
	private String save(Gift gift, ModelMap model) {
		Map<String, String> result = giftService.save(gift);
		model.addAttribute(result.get("messageType"), result.get("message"));
		return list(model);
	}
	
	@GetMapping("/listar")
	private String list(ModelMap model) {
		model.addAttribute("gift", giftService.findAll());
		return "/gift/list";
	}
	
	@GetMapping("/excluir/{id}")
	private String delete(@PathVariable("id") Long id, ModelMap model) {
		giftService.delete(id);
		return list(model);
	}
	
	@GetMapping("/editar/{id}")
	private String preEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("gift", giftService.findById(id));
		return "/gift/edition";
	}
	
	@PostMapping("/editar")
	private String edit(Gift gift, RedirectAttributes attr) {
		Map<String, String> result = giftService.update(gift);
		attr.addFlashAttribute(result.get("messageType"), result.get("message"));
		return "redirect:/presentes/listar";
	}

}
