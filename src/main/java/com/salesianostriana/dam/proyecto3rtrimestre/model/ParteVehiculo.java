package com.salesianostriana.dam.proyecto3rtrimestre.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	private int tiempoEmpleado;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaLlegada, fechaSalida, fechaFactura;
	@Lob
	private String observaciones;
	
	private boolean is_a_b, parteCerrado;
	private double total;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Vehiculo vehiculo;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Trabajador trabajador;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Cliente cliente;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy = "parteVehiculo",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<LineaFactura> lineaFacturaLista = new ArrayList<>();
	
	public void addLineaFactura(LineaFactura lf) {
		lf.setParteVehiculo(this);
		this.lineaFacturaLista.add(lf);
	}
	
	public void removeLineaFactura(LineaFactura lf) {
		this.lineaFacturaLista.remove(lf);
		lf.setParteVehiculo(null);	
	}
}
