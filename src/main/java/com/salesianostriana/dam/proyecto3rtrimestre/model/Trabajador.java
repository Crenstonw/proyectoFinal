package com.salesianostriana.dam.proyecto3rtrimestre.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	private String nombre, apellidos, dni;
	
	private LocalDate fechaNacimiento;
	
	private String fotoTrabajador;
	
	@OneToMany
	private ParteVehiculo parteVehiculo;
}
