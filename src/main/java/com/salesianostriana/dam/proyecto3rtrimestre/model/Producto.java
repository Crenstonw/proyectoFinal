package com.salesianostriana.dam.proyecto3rtrimestre.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;

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
	
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_proveedor"))
	private long idProveedor;
	
	private String nombre;
	private double precio, pvp;
	@Lob
	private String descripcion;
}
