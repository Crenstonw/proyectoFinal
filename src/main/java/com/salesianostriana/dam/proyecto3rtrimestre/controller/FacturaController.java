package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.ParteVehiculo;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.ParteVehiculoService;

@Controller
@RequestMapping("/inicio/factura")
public class FacturaController {
	@Autowired
	private ParteVehiculoService parteVehiculoService;

	@GetMapping("/")
	public String buscarFactura(Model model) {
		model.addAttribute("partes", parteVehiculoService.findAll());
		return "listaFactura";
	}
	
	@PostMapping("/factura/submit")
	public String mostrarFactura(ParteVehiculo parteVehiculo, Model model) {
		return "";
	}
}
