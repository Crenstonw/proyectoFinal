package com.salesianostriana.dam.proyecto3rtrimestre.model;

import java.time.LocalDate;

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
public class Trabajador {
	
	@Id
	@GeneratedValue
	private Long idTrabajador;
	
	private LocalDate fechaNacimiento;
	private String dni, nombre, apellidos;
	private String fotoTrabajador;
	private Boolean isAdmin;
	
	@ManyToOne
	private ParteVehiculo parteVehiculo;
}
