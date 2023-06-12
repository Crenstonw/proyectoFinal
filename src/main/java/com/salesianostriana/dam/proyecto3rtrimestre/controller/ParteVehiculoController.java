package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Cliente;
import com.salesianostriana.dam.proyecto3rtrimestre.model.LineaFactura;
import com.salesianostriana.dam.proyecto3rtrimestre.model.ParteVehiculo;
import com.salesianostriana.dam.proyecto3rtrimestre.model.Trabajador;
import com.salesianostriana.dam.proyecto3rtrimestre.model.Vehiculo;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.ClienteService;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.LineaFacturaService;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.ParteVehiculoService;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.TrabajadorService;
import com.salesianostriana.dam.proyecto3rtrimestre.servicios.VehiculoService;

@Controller
@RequestMapping("/inicio/listaParte")
public class ParteVehiculoController {
	@Autowired
	private LineaFacturaService lineaFacturaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private VehiculoService vehiculoService;
	@Autowired
	private TrabajadorService trabajadorService;
	@Autowired
	private ParteVehiculoService parteVehiculoService;
	
	@GetMapping("/")
	public String showFormParteVehiculo(Model model) {
		model.addAttribute("partes", parteVehiculoService.findAll());
		return "listaParte";
		
	}
	
	@PostMapping("/nuevo")
	public String nuevoParteVehiculo(@AuthenticationPrincipal Trabajador t, Model model) {
		List<Vehiculo> vehiculos = vehiculoService.findAll();	
		List<Cliente> clientes = clienteService.findAll();
		model.addAttribute("parte", new ParteVehiculo());
		model.addAttribute("trabajadores", t);
		model.addAttribute("clientes", clientes);
		model.addAttribute("vehiculos", vehiculos);	
		return "formularios/form-parte";
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNuevoProducto(ParteVehiculo parteVehiculo, Model model) {
		
		parteVehiculoService.save(parteVehiculo);
		return "redirect:/inicio/listaParte/";

	}
	
	@GetMapping("/editar/{idParte}")
	public String editarparteVehiculo(@PathVariable("idParte") Long idParte, Model model, String apellidosTrabajador, String apellidosCliente) {
		ParteVehiculo parteVehiculo = parteVehiculoService.findById(idParte);
		model.addAttribute("trabajadores", trabajadorService.findByApellidos(apellidosTrabajador));
		model.addAttribute("clientes", clienteService.findByApellidos(apellidosCliente));
		model.addAttribute("vehiculos", vehiculoService.findAll());
		model.addAttribute("lineaFacturas", lineaFacturaService.findAll());
		
		if(parteVehiculo != null) {
			model.addAttribute("parte", parteVehiculo);
			return "formularios/form-parte";
		} else {
			return "listaParte";
		}
	}
	
	@PostMapping("/editar/{idParte}/nuevoArticulo/submit")
	public String submitNuevoProducto(LineaFactura lineaFactura, Model model) {
		lineaFacturaService.save(lineaFactura);
		return "redirect:/inicio/listaParte/editar/{idParte}";

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
