package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.LineaFactura;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.LineaFacturaService;
@Controller
@RequestMapping("/inicio/articulo/")
public class LineaFacturaController {
	@Autowired
	private LineaFacturaService lineaFacturaService;
	
	@PostMapping("/nuevo")
	public String nuevoArticulo( Model model) {
			model.addAttribute("lineaFactura", new LineaFactura());
			return "formularios/form-parte";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitArticulo(LineaFactura lineaFactura, Model model) {
		lineaFacturaService.save(lineaFactura);
		return "redirect:/inicio/listaParte";
		
		
	}
	
	@GetMapping("/editar/{codLineaFactura}")
	public String editarparteVehiculo(@PathVariable("codLineaFactura") Long codLineaFactura, Model model) {
		LineaFactura lineaFactura= lineaFacturaService.findById(codLineaFactura);
		model.addAttribute("lineaFacturas", lineaFacturaService.findAll());
		
		if(lineaFactura != null) {
			model.addAttribute("lineaFactura", lineaFactura);
			return "formularios/form-parte";
		} else {
			return "listaParte";
		}
	}
	
	@GetMapping("/borrar/{idParte}")
	public String borrarParteVehiculo(@PathVariable("idParte") Long codLineaFactura, Model model) {
		
		LineaFactura lineaFactura = lineaFacturaService.findById(codLineaFactura);
		
		if(lineaFactura != null) {
			lineaFacturaService.delete(lineaFactura);
		}
		
		return "redirect:/inicio/listaParte/";
	}
}
