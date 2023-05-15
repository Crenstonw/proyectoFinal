package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Vehiculo;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.VehiculoService;

@Controller
@RequestMapping("/inicio/listaVehiculo")
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;
	
	@GetMapping("/")
	public String showFormVehiculo(Model model) {
		model.addAttribute("vehiculos", vehiculoService.findAll());
		return "listaVehiculo";
		
	}
	
	@PostMapping("/nuevo")
	public String nuevoVehiculo(Model model) {
		model.addAttribute("vehiculo", new Vehiculo());
		return "formularios/form-vehiculo";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNuevoVehiculo(Vehiculo vehiculo, Model model) {

		vehiculoService.save(vehiculo);
		return "redirect:/inicio/listaVehiculo/";

	}
	
	@GetMapping("/editar/{matricula}")
	public String editarVehiculo(@PathVariable("matricula") String matricula, Model model) {
		Vehiculo vehiculo = vehiculoService.findById(matricula);
		
		if(vehiculo != null) {
			model.addAttribute("vehiculo", vehiculo);
			return "formularios/form-vehiculo";
		} else {
			return "listaVehiculo";
		}
	}
	
	@GetMapping("/borrar/{matricula}")
	public String borrarVehiculo(@PathVariable("matricula") String matricula, Model model) {
		
		Vehiculo vehiculo = vehiculoService.findById(matricula);
		
		if(vehiculo != null) {
			vehiculoService.delete(vehiculo);
		}
		
		return "redirect:/inicio/listaVehiculo/";
	}
}

