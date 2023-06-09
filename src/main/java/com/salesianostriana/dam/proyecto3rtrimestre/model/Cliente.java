package com.salesianostriana.dam.proyecto3rtrimestre.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
public class Cliente {
	
	@Id
	@GeneratedValue
	private Long codCliente;
	
	private String dni, nombre, apellidos, telefono, email;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy = "cliente",
			fetch = FetchType.EAGER
	)
	private List<ParteVehiculo> parteVehiculoLista = new ArrayList<>();
	
	public void addParteVehiculo(ParteVehiculo pv) {
		pv.setCliente(this);
		this.parteVehiculoLista.add(pv);
	}
	
	public void removeParteVehiculo(ParteVehiculo pv) {
		this.parteVehiculoLista.remove(pv);
		pv.setCliente(null);
	}
}
