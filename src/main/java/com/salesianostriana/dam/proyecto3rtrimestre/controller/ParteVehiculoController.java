package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.ParteVehiculo;
import com.salesianostriana.dam.proyecto3rtrimestre.model.Producto;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.ParteVehiculoService;

@Controller
@RequestMapping("/inicio/listaParte")
public class ParteVehiculoController {
	@Autowired
	private ParteVehiculoService parteVehiculoService;
	
	@GetMapping("/")
	public String showFormParteVehiculo(Model model) {
		model.addAttribute("parte", parteVehiculoService.findAll());
		return "listaParte";
		
	}
	
	@PostMapping("/nuevo")
	public String nuevoParteVehiculo(Model model) {
		model.addAttribute("parte", new Producto());
		return "formularios/form-parte";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNuevoParteVehiculo(ParteVehiculo parteVehiculo, Model model) {

		parteVehiculoService.save(parteVehiculo);
		return "redirect:/inicio/listaParte/";

	}
	
	@GetMapping("/editar/{idParte}")
	public String editarparteVehiculo(@PathVariable("idParte") Long idParte, Model model) {
		ParteVehiculo parteVehiculo = parteVehiculoService.findById(idParte);
		
		if(parteVehiculo != null) {
			model.addAttribute("parte", parteVehiculo);
			return "formularios/form-parte";
		} else {
			return "listaParte";
		}
	}
	
	@GetMapping("/borrar/{idParte}")
	public String borrarParteVehiculo(@PathVariable("idParte") Long idParte, Model model) {
		
		ParteVehiculo parteVehiculo = parteVehiculoService.findById(idParte);
		
		if(parteVehiculo != null) {
			parteVehiculoService.delete(parteVehiculo);
		}
		
		return "redirect:/inicio/listaParte/";
	}
}
