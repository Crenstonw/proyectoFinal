package com.salesianostriana.dam.proyecto3rtrimestre.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Cliente;
import com.salesianostriana.dam.proyecto3rtrimestre.repos.RepositorioCliente;

@Service
public class ClienteService {
	@Autowired
	private RepositorioCliente repositorio;
	
	public List<Cliente> findAll() {
		return repositorio.findAll();
	}
	
	public Cliente save(Cliente c) {
		return repositorio.save(c);
	}
	
	public Optional<Cliente> findByApellidos(String apellidos) {
		return repositorio.findByApellidos(apellidos);
	}
	
	public Cliente findById(Long codCliente) {
		return repositorio.findById(codCliente).orElse(null);
	}
	
	public Cliente delete(Cliente c) {
		Cliente result = findById(c.getCodCliente());
		repositorio.delete(result);
		return result;
	}
}
