package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Cliente;

@Controller
public class ClienteController {

	@GetMapping("/cliente")
	public String showFormCliente(Model model) {
		Cliente cliente= new Cliente();
		model.addAttribute("clienteForm", cliente);
		
		return "formCliente";
	}
	
	@PostMapping("/addCliente")
	public String submit(@ModelAttribute("clienteForm") Cliente cliente, Model model) {
		model.addAttribute("cliente", cliente);
		return "view";
	}
}
