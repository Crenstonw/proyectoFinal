package com.salesianostriana.dam.proyecto3rtrimestre.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Producto;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, String> {

}
