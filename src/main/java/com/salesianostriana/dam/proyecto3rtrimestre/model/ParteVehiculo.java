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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParteVehiculo {

	@Id
	@GeneratedValue
	private Long idParte;
	
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_vehiculo"))
	private Vehiculo vehiculo;
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_trabajador"))
	private Trabajador trabajador;
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_cliente"))
	private Cliente cliente;
	private int tiempoEmpleado;
	private LocalDateTime fechaLlegada, fechaSalida;
	private String observaciones;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "parteVehiculo", 
			fetch = FetchType.EAGER, 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Cliente> clienteLista = new ArrayList<>();
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "parteVehiculo", 
			fetch = FetchType.EAGER, 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Vehiculo> vehiculoLista= new ArrayList<>();
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "parteVehiculo", 
			fetch = FetchType.EAGER, 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Trabajador> trabajadorLista= new ArrayList<>();
	
	public void addToVehiculo(Vehiculo vehiculo) {
		vehiculo.getMatricula(this);
		this.addToVehiculo(vehiculo);
	}
	
	public void removeFromVehiculo(Vehiculo vehiculo) {
		vehiculo.getParteVehiculo().removeFromVehiculo(vehiculo);
		this.vehiculo=null;
	}
	
	public void addToTrabajador(Trabajador trabajador) {
		this.trabajador=trabajador;
		trabajador.getIdTrabajador().addToTrabajador(trabajador);
	}
	
	public void removeFromTrabajador(Trabajador trabajador) {
		trabajador.getIdTrabajador();
		this.trabajador=null;
	}
	
	public void addToCliente(Cliente cliente) {
		this.cliente=cliente;
		cliente.getParteVehiculo().addToCliente(cliente);
	}
	
	public void removeFromCliente(Cliente cliente) {
		cliente.getParteVehiculo().removeFromCliente(cliente);
		this.cliente=null;
	}
}
