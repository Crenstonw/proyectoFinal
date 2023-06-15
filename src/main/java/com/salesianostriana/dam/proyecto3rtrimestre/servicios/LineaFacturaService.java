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
	
	public List<LineaFactura> findAll() {
		return repositorio.findAll();
	}
	
	public LineaFactura save(LineaFactura lf) {
		return repositorio.save(lf);
	}
	
	public LineaFactura findById(Long codLineaFactura) {
		return repositorio.findById(codLineaFactura).orElse(null);
	}
	
	public LineaFactura delete(LineaFactura lf) {
		LineaFactura result = findById(lf.getCodLineaFactura());
		repositorio.delete(result);
		return result;
	}
	
	public List<LineaFactura> findByParte(Long idParte) {
		return repositorio.findByidParte(idParte);
	}
	
	/*public List<LineaFactura> findByIdParte(Long idParte) {
		return this.repositorio.findByidParte(idParte);
	}*/
}
