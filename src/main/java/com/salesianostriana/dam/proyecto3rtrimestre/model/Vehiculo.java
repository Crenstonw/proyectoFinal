package com.salesianostriana.dam.proyecto3rtrimestre.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehiculo {

	@Id
	private String matricula;
	
	@Enumerated(EnumType.STRING)
	private TipoVehiculo tipoVehiculo;
	
	private String bastidor, marca, modelo;
	
	/*@OneToMany(mappedBy = "vehiculo", fetch = FetchType.EAGER)
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<ParteVehiculo> parteVehiculo = new ArrayList<>();*/
}
