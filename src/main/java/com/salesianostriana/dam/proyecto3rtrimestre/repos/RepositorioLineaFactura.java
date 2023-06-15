package com.salesianostriana.dam.proyecto3rtrimestre.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyecto3rtrimestre.model.LineaFactura;

public interface RepositorioLineaFactura extends JpaRepository<LineaFactura, Long> {
	@Query(value = "Select lf from LineaFactura lf where lf.parteVehiculo.idParte = :idParte")
	List<LineaFactura> findByidParte(@Param("idParte") Long idParte);
	
}
