package com.salesianostriana.dam.proyecto3rtrimestre.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Vehiculo;
import com.salesianostriana.dam.proyecto3rtrimestre.repos.RepositorioVehiculo;

@Service
public class VehiculoService {

	@Autowired
	private RepositorioVehiculo repositorio;
	
	public List<Vehiculo> findAll() {
		return repositorio.findAll();
	}
	
	public Vehiculo save(Vehiculo v) {
		return repositorio.save(v);
	}
	
	public Vehiculo findById(String matricula) {
		return repositorio.findById(matricula).orElse(null);
	}
	
	public Vehiculo delete(Vehiculo v) {
		Vehiculo result = findById(v.getMatricula());
		repositorio.delete(result);
		return result;
	}
}
