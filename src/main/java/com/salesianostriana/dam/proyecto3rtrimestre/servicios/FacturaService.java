package com.salesianostriana.dam.proyecto3rtrimestre.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Factura;
import com.salesianostriana.dam.proyecto3rtrimestre.repos.RepositorioFactura;

@Service
public class FacturaService {
	@Autowired
	private RepositorioFactura repositorio;
	
	public List<Factura> findAll() {
		return repositorio.findAll();
	}
	
	public Factura save(Factura f) {
		return repositorio.save(f);
	}
	
	public Factura findById(Long numFactura) {
		return repositorio.findById(numFactura).orElse(null);
	}
	
	public Factura delete(Factura f) {
		Factura result = findById(f.getNumFactura());
		repositorio.delete(result);
		return result;
	}
}
