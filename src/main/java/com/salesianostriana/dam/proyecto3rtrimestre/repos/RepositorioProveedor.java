package com.salesianostriana.dam.proyecto3rtrimestre.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Proveedor;

@Repository
public interface RepositorioProveedor extends JpaRepository<Proveedor, Long>{

}
