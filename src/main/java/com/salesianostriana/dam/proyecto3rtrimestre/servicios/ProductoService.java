package com.salesianostriana.dam.proyecto3rtrimestre.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Producto;
import com.salesianostriana.dam.proyecto3rtrimestre.repos.RepositorioProducto;

@Service
public class ProductoService {
	@Autowired
	private RepositorioProducto repositorio;
	
	public List<Producto> findAll() {
		return repositorio.findAll();
	}
	
	public Producto save(Producto p) {
		return repositorio.save(p);
	}
	
	public Producto findById(String referencia) {
		return repositorio.findById(referencia).orElse(null);
	}
	
	public Producto delete(Producto p) {
		Producto result = findById(p.getReferencia());
		repositorio.delete(result);
		return result;
	}
}
