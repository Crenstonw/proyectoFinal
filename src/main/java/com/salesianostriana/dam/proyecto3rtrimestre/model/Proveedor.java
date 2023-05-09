package com.salesianostriana.dam.proyecto3rtrimestre.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
public class Proveedor {
	@Id
	@GeneratedValue
	private Long idProveedor;
	
	private String nombre, direccion, descripcion;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "proveedor", 
			fetch = FetchType.EAGER, 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Producto> productoLista= new ArrayList<>();
	
	public void addToProducto(Producto producto) {
		producto.getIdProveedor(this);
	}
}
