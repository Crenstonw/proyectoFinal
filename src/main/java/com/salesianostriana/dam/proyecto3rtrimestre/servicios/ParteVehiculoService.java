package com.salesianostriana.dam.proyecto3rtrimestre.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto3rtrimestre.model.ParteVehiculo;
import com.salesianostriana.dam.proyecto3rtrimestre.repos.RepositorioParteVehiculo;

@Service
public class ParteVehiculoService {
	@Autowired
	private RepositorioParteVehiculo repositorio;
	
	public List<ParteVehiculo> findAll() {
		return repositorio.findAll();
	}
	
	public ParteVehiculo save(ParteVehiculo pv) {
		return repositorio.save(pv);
	}
	
	public ParteVehiculo findById(Long idParte) {
		return repositorio.findById(idParte).orElse(null);
	}
	
	public ParteVehiculo delete(ParteVehiculo pv) {
		ParteVehiculo result = findById(pv.getIdParte());
		repositorio.delete(pv);
		return result;
	}
	
	/*public List<ParteVehiculo> findByCerrado(Boolean parteCerrado) {
		parteCerrado = true;
		
		return this.repositorio.findByCerrado(parteCerrado);
	}*/
}
