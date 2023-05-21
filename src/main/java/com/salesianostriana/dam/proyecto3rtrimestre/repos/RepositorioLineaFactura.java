package com.salesianostriana.dam.proyecto3rtrimestre.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyecto3rtrimestre.model.LineaFactura;

public interface RepositorioLineaFactura extends JpaRepository<LineaFactura, Long> {
	@Query("SELECT COUNT(f) FROM LineaFactura f WHERE f.factura.numFactura = :numFactura")
	List<LineaFactura> findByNumFactura(Long numFactura);
}
