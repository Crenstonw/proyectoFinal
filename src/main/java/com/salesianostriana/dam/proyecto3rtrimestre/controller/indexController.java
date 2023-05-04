package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

	@GetMapping({"/", "/iniciarSesion"})
	public String showInicio(Model model) {
		return "formCliente";
	}
}
