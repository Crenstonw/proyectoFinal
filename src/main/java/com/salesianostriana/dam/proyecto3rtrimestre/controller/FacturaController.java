package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.LineaFactura;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.LineaFacturaService;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.ParteVehiculoService;

@Controller
@RequestMapping("/inicio/factura")
public class FacturaController {
	@Autowired
	private ParteVehiculoService parteVehiculoService;
	@Autowired
	private LineaFacturaService lineaFacturaService;

	@GetMapping("/")
	public String buscarFactura(Model model) {
		model.addAttribute("partes", parteVehiculoService.findAll());
		return "listaFactura";
	}
	
	@PostMapping("/submit")
	public String submitBuscarFactura(Long idParte, Model model) {
		
		return "redirect:/inicio/factura/mostrar/{idParte}";
	}
	
	@GetMapping("/mostrar/{idParte}")
	public String mostrarFactura(@PathVariable("idParte") Long idParte, Model model) {
		List<LineaFactura> factura = lineaFacturaService.findByParte(idParte);
		model.addAttribute(factura);
		return "formularios/factura-parte";
	}
	
	/*@GetMapping("factura/{idParte}")
	public String nuevaFactura(@PathVariable("idParte") Long idParte, Model model) {
		List<LineaFactura> facturas = lineaFacturaService.findByIdParte(idParte);
		model.addAttribute(facturas);
		return "factura-parte";
	}*/
	
	
}
