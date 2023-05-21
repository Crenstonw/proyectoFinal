package com.salesianostriana.dam.proyecto3rtrimestre.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LineaFactura {
	@Id
	@GeneratedValue
	private Long codLineaFactura;
	
	@ManyToOne
	private ParteVehiculo parteVehiculo;
	
	@ManyToOne
	private Producto producto;
	
	@ManyToOne
	private Factura factura;
	
	private int cantidad;
}
