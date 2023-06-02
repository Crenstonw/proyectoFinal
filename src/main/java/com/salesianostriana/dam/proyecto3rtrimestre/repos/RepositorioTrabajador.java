package com.salesianostriana.dam.proyecto3rtrimestre.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Trabajador;

public interface RepositorioTrabajador extends JpaRepository<Trabajador, Long> {
	Optional<Trabajador> findByUsername(String username);
	Optional<Trabajador> findByName(String name);
}
