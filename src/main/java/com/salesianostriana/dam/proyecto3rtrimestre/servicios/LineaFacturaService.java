package com.salesianostriana.dam.proyecto3rtrimestre.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto3rtrimestre.model.LineaFactura;
import com.salesianostriana.dam.proyecto3rtrimestre.repos.RepositorioLineaFactura;

@Service
public class LineaFacturaService {
	@Autowired
	private RepositorioLineaFactura repositorio;
	
	public List<LineaFactura> searchLineasFactura(Long numFactura) {
		return repositorio.findByNumFactura(numFactura);
	}
}
