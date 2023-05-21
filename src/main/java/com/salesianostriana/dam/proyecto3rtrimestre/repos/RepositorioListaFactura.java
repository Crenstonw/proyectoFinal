package com.salesianostriana.dam.proyecto3rtrimestre.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyecto3rtrimestre.model.LineaFactura;

public interface RepositorioListaFactura extends JpaRepository<LineaFactura, Long> {

}
