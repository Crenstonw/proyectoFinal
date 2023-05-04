package com.salesianostriana.dam.proyecto3rtrimestre.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class Cliente {
	
	@Id
	@GeneratedValue
	private Long codCliente;
	
	private String dni, nombre, apellidos, telefono, email, fotoDni;
	
	/*@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<ParteVehiculo> parteVehiculo = new ArrayList<>();*/
}
