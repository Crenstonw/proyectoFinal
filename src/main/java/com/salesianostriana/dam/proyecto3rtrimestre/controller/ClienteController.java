package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Cliente;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.ClienteService;

@Controller
@RequestMapping("/inicio/listaCliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/")
	public String showFormCliente(Model model) {
		model.addAttribute("clientes", clienteService.findAll());
		return "listaCliente";
		
	}
	
	@PostMapping("/nuevo")
	public String nuevoCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "formularios/form-cliente";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNuevoCliente(Cliente cliente, Model model) {

		clienteService.save(cliente);
		return "redirect:/inicio/listaCliente/";

	}
	
	@GetMapping("/editar/{codCliente}")
	public String editarCliente(@PathVariable("codCliente") Long codCliente, Model model) {
		Cliente cliente = clienteService.findById(codCliente);
		
		if(cliente != null) {
			model.addAttribute("cliente", cliente);
			return "formularios/form-cliente";
		} else {
			return "listaCliente";
		}
	}
	
	@GetMapping("/borrar/{codCliente}")
	public String borrarCliente(@PathVariable("codCliente") Long codCliente, Model model) {
		try {
			Cliente cliente = clienteService.findById(codCliente);
			
			if(cliente != null) {
				clienteService.delete(cliente);
			}
			
			return "redirect:/inicio/listaCliente/";
		} catch(Exception ErrorEliminarObjeto) {
			return "errorObjetoUsado";
		}
	}
}
