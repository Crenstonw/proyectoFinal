package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Proveedor;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.ProveedorService;

@Controller
@RequestMapping("/inicio/listaProveedor")
public class ProveedorController {
	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/")
	public String showFormProveedor(Model model) {
		model.addAttribute("proveedores", proveedorService.findAll());
		return "listaProveedor";
		
	}
	
	@PostMapping("/nuevo")
	public String nuevoProveedor(Model model) {
		model.addAttribute("proveedor", new Proveedor());
		return "formularios/form-Proveedor";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNuevoProveedor(Proveedor proveedor, Model model) {
		
		proveedorService.save(proveedor);
		return "redirect:/inicio/listaProveedor/";

	}
	
	@GetMapping("/editar/{idProveedor}")
	public String editarProveedor(@PathVariable("idProveedor") Long idProveedor, Model model) {
		Proveedor proveedor = proveedorService.findById(idProveedor);
		
		if(proveedor != null) {
			model.addAttribute("proveedor", proveedor);
			return "formularios/form-Proveedor";
		} else {
			return "listaProveedor";
		}
	}
	
	@GetMapping("/borrar/{idProveedor}")
	public String borrarProveedor(@PathVariable("idProveedor") Long idProveedor, Model model) {
		
		Proveedor proveedor = proveedorService.findById(idProveedor);
		
		if(proveedor != null) {
			proveedorService.delete(proveedor);
		}
		
		return "redirect:/inicio/listaProveedor/";
	}
}
