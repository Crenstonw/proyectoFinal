package com.salesianostriana.dam.proyecto3rtrimestre.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyecto3rtrimestre.model.ParteVehiculo;
@Repository
public interface RepositorioParteVehiculo extends JpaRepository<ParteVehiculo, Long> {
	//List<ParteVehiculo> findByCerrado(Boolean parteCerrado);
}
