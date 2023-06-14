package com.salesianostriana.dam.proyecto3rtrimestre.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Trabajador implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idTrabajador;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private String dni, nombre, apellidos;
	private String fotoTrabajador;
	private Boolean isAdmin;
	private String username, password;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		role += (isAdmin) ? "ADMIN" : "USER";
		return List.of(new SimpleGrantedAuthority(role));
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy = "trabajador",
			fetch = FetchType.LAZY
	)
	private List<ParteVehiculo> parteVehiculoLista = new ArrayList<>();
	
	public void addPArteVehiculo(ParteVehiculo pv) {
		pv.setTrabajador(this);
		this.parteVehiculoLista.add(pv);
	}
	
	public void removeParteVehiculo(ParteVehiculo pv) {
		this.parteVehiculoLista.remove(pv);
		pv.setTrabajador(null);
	}
}
