package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Trabajador;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.TrabajadorService;

@Controller
@RequestMapping("/inicio/listaTrabajador")
public class TrabajadorController {

	@Autowired
	private TrabajadorService trabajadorService;
	
	@GetMapping("/")
	public String showFormTrabajador(Model model) {
		model.addAttribute("trabajadores", trabajadorService.findAll());
		return "admin/listaTrabajador";
		
	}
	
	@PostMapping("/nuevo")
	public String nuevoTrabajador(Model model) {
		model.addAttribute("trabajador", new Trabajador());
		return "admin/form-trabajador";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNuevoTrabajador(Trabajador trabajador, Model model) {

		trabajadorService.save(trabajador);
		return "redirect:/inicio/listaTrabajador/";

	}
	
	@GetMapping("/editar/{idTrabajador}")
	public String editarTrabajador(@PathVariable("idTrabajador") Long idTrabajador, Model model) {
		Trabajador trabajador = trabajadorService.findById(idTrabajador);
		
		if(trabajador != null) {
			model.addAttribute("trabajador", trabajador);
			return "admin/form-trabajador";
		} else {
			return "admin/listaTrabajador";
		}
	}
	
	@GetMapping("/borrar/{idTrabajador}")
	public String borrarTrabajador(@PathVariable("idTrabajador") Long idTrabajador, Model model) {
		
		Trabajador trabajador = trabajadorService.findById(idTrabajador);
		
		if(trabajador != null) {
			trabajadorService.delete(trabajador);
		}
		
		return "redirect:/inicio/listaTrabajador/";
	}
	
	
}
