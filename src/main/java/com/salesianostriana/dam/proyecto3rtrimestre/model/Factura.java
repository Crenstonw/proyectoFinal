package com.salesianostriana.dam.proyecto3rtrimestre.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Factura {
	@Id
	@GeneratedValue
	private Long numFactura;
	private boolean is_a_b;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	private double total;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy = "factura",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<LineaFactura> lineaFacturaLista = new ArrayList<>();
	
	public void addLineaFactura(LineaFactura lf) {
		lf.setFactura(this);
		this.lineaFacturaLista.add(lf);
	}
	
	public void removeLineaFactura(LineaFactura lf) {
		this.lineaFacturaLista.remove(lf);
		lf.setFactura(null);	
	}
	
	public boolean isIs_a_b() {
	    return is_a_b;
	}
}
