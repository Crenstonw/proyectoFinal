package com.salesianostriana.dam.proyecto3rtrimestre.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Producto {

	@Id
	private String referencia;
	private String nombre;
	private double precio, pvp;
	@Lob
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_producto_proveedor"))
	private Proveedor proveedor;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy = "producto",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<LineaFactura> lineaFacturaLista = new ArrayList<>();
	
	public void addLineaFactura(LineaFactura lf) {
		lf.setProducto(this);
		this.lineaFacturaLista.add(lf);
	}
	
	public void removeLineaFactura(LineaFactura lf) {
		this.lineaFacturaLista.remove(lf);
		lf.setProducto(this);	
	}
}
