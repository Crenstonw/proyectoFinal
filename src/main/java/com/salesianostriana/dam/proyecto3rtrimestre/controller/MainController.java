package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping({"/", "/iniciarSesion"})
	public String showInicioSesion() {
		return "index";
	}
	
	@GetMapping("/inicio")
	public String showInicio() {
		return "inicio";
	}
}
