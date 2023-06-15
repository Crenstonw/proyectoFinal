package com.salesianostriana.dam.proyecto3rtrimestre.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Cliente;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Long> {
	List<Cliente> findByApellidos(String apellidos);
}
