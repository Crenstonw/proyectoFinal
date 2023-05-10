package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	@GetMapping("/inicio")
	public String showInicio() {
		return "inicio";
	}
}
