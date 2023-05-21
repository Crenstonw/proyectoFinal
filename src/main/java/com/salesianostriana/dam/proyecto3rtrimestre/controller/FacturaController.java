package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Factura;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.FacturaService;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.LineaFacturaService;

@Controller
@RequestMapping("/inicio/listaFactura")
public class FacturaController {
	@Autowired
	private FacturaService facturaService;
	
	@Autowired
	private LineaFacturaService lineaFacturaService;
	
	@GetMapping("/")
	public String showFormProducto(Model model) {
		model.addAttribute("facturas", facturaService.findAll());
		return "listaFactura";
		
	}
	
	@PostMapping("/nuevo")
	public String nuevaFactura(Model model) {
		model.addAttribute("factura", new Factura());
		return "formularios/form-factura";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNuevaFactura(Factura factura, Model model) {

		facturaService.save(factura);
		return "redirect:/inicio/listaFactura/";

	}
	
	@GetMapping("/editar/{numFactura}")
	public String editarFactura(@PathVariable("numFactura") Long numFactura, Model model) {
		Factura factura = facturaService.findById(numFactura);
		
		if(factura != null) {
			model.addAttribute("factura", factura);
			return "formularios/form-factura";
		} else {
			return "listaFactura";
		}
	}
	
	@GetMapping("/borrar/{numFactura}")
	public String borrarFactura(@PathVariable("numFactura") Long numFactura, Model model) {
		
		Factura factura = facturaService.findById(numFactura);
		
		if(factura != null) {
			facturaService.delete(factura);
		}
		
		return "redirect:/inicio/listaFactura/";
	}
}
