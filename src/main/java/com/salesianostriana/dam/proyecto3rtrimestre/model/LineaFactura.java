package com.salesianostriana.dam.proyecto3rtrimestre.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_lineaFactura_parteVehiculo"))
	private ParteVehiculo parteVehiculo;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_lineaFactura_producto"))
	private Producto producto;

	private int cantidad;
}
