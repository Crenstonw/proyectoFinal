package com.salesianostriana.dam.proyecto3rtrimestre.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Cliente;

public interface RepositorioCliente extends JpaRepository<Cliente, Long> {

}
