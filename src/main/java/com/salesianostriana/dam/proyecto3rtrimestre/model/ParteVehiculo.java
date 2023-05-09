package com.salesianostriana.dam.proyecto3rtrimestre.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class ParteVehiculo {

	@Id
	@GeneratedValue
	private Long idParte;
	
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_vehiculo"))
	private Vehiculo vehiculo;
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_cliente"))
	private Cliente cliente;
	private int tiempoEmpleado;
	private LocalDateTime fechaLlegada, fechaSalida;
	private String observaciones;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy = "parteVehiculo",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Vehiculo> vehiculoLista = new ArrayList<>();
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy = "parteVehiculo",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Cliente> clienteLista = new ArrayList<>();
	
	
	public void addVehiculo(Vehiculo v) {
		v.setParteVehiculo(this);
		this.vehiculoLista.add(v);
	}
	
	public void removeVehiculo(Vehiculo v) {
		this.vehiculoLista.remove(v);
		v.setParteVehiculo(null);
	}
	
	public void addCliente(Cliente c) {
		c.setParteVehiculo(this);
		this.clienteLista.add(c);
	}
	
	public void removeAsiento(Cliente c) {
		this.clienteLista.remove(c);
		c.setParteVehiculo(null);
	}
}
