package com.salesianostriana.dam.proyecto3rtrimestre.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Proveedor;
import com.salesianostriana.dam.proyecto3rtrimestre.repos.RepositorioProveedor;

@Service
public class ProveedorService {
	@Autowired
	private RepositorioProveedor repositorio;
	
	public List<Proveedor> findAll() {
		return repositorio.findAll();
	}
	
	public Proveedor save(Proveedor pv) {
		return repositorio.save(pv);
	}
	
	public Proveedor findById(Long idProveedor) {
		return repositorio.findById(idProveedor).orElse(null);
	}
	
	public Proveedor delete(Proveedor pv) {
		Proveedor result = findById(pv.getIdProveedor());
		repositorio.delete(result);
		return result;
	}
}
