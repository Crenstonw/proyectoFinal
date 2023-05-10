package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Cliente;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.ClienteService;

@Controller
@RequestMapping("/listaCliente/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/")
	public String showFormCliente(Model model) {
		model.addAttribute("producto", new Cliente());
		
		model.addAttribute("categorias", clienteService.findAll());
		return "listaCliente";
		
	}
	
	@PostMapping("/addCliente")
	public String submitNuevoCliente(@ModelAttribute("cliente") Cliente cliente, Model model) {
		model.addAttribute("cliente", cliente);
		return "redirect:/listaCliente";
	}
	
	@GetMapping("/editar/{id}")
	public String editarCliente(@PathVariable("id") Long codCliente, Model model) {
		Cliente cliente = clienteService.findById(codCliente);
		
		if(cliente != null) {
			model.addAttribute("cliente", cliente);
			return "listaCliente";
		} else {
			return "redirect:/listaCliente";
		}
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarCliente(@PathVariable("id") Long codCliente, Model model) {
		Cliente cliente = clienteService.findById(codCliente);
		
		if(cliente != null) {
			clienteService.delete(cliente);
		}
		
		return "redirect:/listaCliente";
	}
}
