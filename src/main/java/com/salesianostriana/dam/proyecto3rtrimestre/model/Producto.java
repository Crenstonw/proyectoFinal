package com.salesianostriana.dam.proyecto3rtrimestre.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Producto {

	@Id
	private String referencia;
	private String nombre;
	private double precio, pvp;
	@Lob
	private String descripcion;
	
	@ManyToOne
	private Proveedor proveedor;
}
