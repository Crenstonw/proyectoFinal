/*package com.salesianostriana.dam.proyecto3rtrimestre.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParteVehiculo {

	@Id
	@GeneratedValue
	private Long idParte;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_vehiculo"))
	private Vehiculo vehiculo;
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_cliente"))
	private Cliente cliente;
	private int tiempoEmpleado;
	private LocalDateTime fechaLlegada, fechaSalida;
	private String observaciones;
	
	public void addToVehiculo(Vehiculo vehiculo) {
		this.vehiculo=vehiculo;
		vehiculo.getParteVehiculo().add(this);
	}
	
	public void removeFromVehiculo(Vehiculo vehiculo) {
		vehiculo.getParteVehiculo().remove(this);
		this.vehiculo=null;
	}
	
	public void addToCliente(Cliente cliente) {
		this.cliente=cliente;
		cliente.getParteVehiculo().add(this);
	}
	
	public void removeFromCliente(Cliente cliente) {
		cliente.getParteVehiculo().remove(this);
		this.cliente=null;
	}
}*/
