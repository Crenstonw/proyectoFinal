package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Producto;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.ProductoService;

@Controller
@RequestMapping("/inicio/listaProducto")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/")
	public String showFormProducto(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "listaProducto";
		
	}
	
	@PostMapping("/nuevo")
	public String nuevoProducto(Model model) {
		model.addAttribute("producto", new Producto());
		return "formularios/form-producto";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNuevoProducto(Producto producto, Model model) {

		productoService.save(producto);
		return "redirect:/inicio/listaProducto/";

	}
	
	@GetMapping("/editar/{referencia}")
	public String editarProducto(@PathVariable("referencia") String referencia, Model model) {
		Producto producto = productoService.findById(referencia);
		
		if(producto != null) {
			model.addAttribute("producto", producto);
			return "formularios/form-producto";
		} else {
			return "listaProducto";
		}
	}
	
	@GetMapping("/borrar/{referencia}")
	public String borrarProducto(@PathVariable("referencia") String referencia, Model model) {
		
		Producto producto = productoService.findById(referencia);
		
		if(producto != null) {
			productoService.delete(producto);
		}
		
		return "redirect:/inicio/listaProducto/";
	}
}
