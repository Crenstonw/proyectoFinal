package com.salesianostriana.dam.proyecto3rtrimestre.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy = "vehiculo",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<ParteVehiculo> parteVehiculoLista = new ArrayList<>();
	
	public void addPArteVehiculo(ParteVehiculo pv) {
		pv.setVehiculo(this);
		this.parteVehiculoLista.add(pv);
	}
	
	public void removeParteVehiculo(ParteVehiculo pv) {
		this.parteVehiculoLista.remove(pv);
		pv.setVehiculo(null);
	}
}
