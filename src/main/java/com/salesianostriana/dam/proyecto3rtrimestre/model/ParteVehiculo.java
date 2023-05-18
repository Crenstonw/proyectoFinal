package com.salesianostriana.dam.proyecto3rtrimestre.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
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
public class ParteVehiculo {

	@Id
	@GeneratedValue
	private Long idParte;
	
	private int tiempoEmpleado;
	private LocalDate fechaLlegada, fechaSalida;
	@Lob
	private String observaciones;
	
	@ManyToOne
	private Vehiculo vehiculo;
	
	@ManyToOne
	private Trabajador trabajador;
	
	@ManyToOne
	private Cliente cliente;
}
