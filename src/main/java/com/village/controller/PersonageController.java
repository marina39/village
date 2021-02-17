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

import com.village.entity.Personage;
import com.village.service.PersonageService;

@Controller
@RequestMapping("/personagens")
public class PersonageController {
	
	@Autowired
	PersonageService personageService;
	
	@GetMapping("/cadastrar")
	public String register(Personage personage) {
		return "/personage/register";
	}
	
	@PostMapping("/salvar")
	public String save(Personage personage, ModelMap model) {		
		Map<String, String> result = personageService.save(personage);		
		model.addAttribute(result.get("messageType"), result.get("mensage"));		
		return register(personage);
	}
	
	@GetMapping("/listar")
	public String list(ModelMap model) {
		model.addAttribute("personage", personageService.findAll());
		return "/personage/list";
	}

	@GetMapping("/excluir/{id}")
	public String delete(@PathVariable("id") Long id, ModelMap model) {
		personageService.delete(id);
		return list(model);
	}
	
	@GetMapping("/editar/{id}")
	public String preEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("personage", personageService.findById(id));
		return "/personage/edition";
	}
	
	@PostMapping("/editar")
	public String edit(Personage personage, RedirectAttributes attr) {
		Map<String, String> result = personageService.update(personage);
		attr.addFlashAttribute(result.get("messageType"), result.get("message"));
		return "redirect:/personagens/listar";
	}
	
}
