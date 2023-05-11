package com.salesianostriana.dam.proyecto3rtrimestre.component;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Trabajador;
import com.salesianostriana.dam.proyecto3rtrimestre.repos.RepositorioTrabajador;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	private final RepositorioTrabajador repo;
	private final PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() {
		
		Trabajador usuario = Trabajador.builder()
				.isAdmin(false)
				.username("user")
				.password(passwordEncoder.encode("1234"))
				.build();
		
		Trabajador admin = Trabajador.builder()
				.isAdmin(true)
				.username("admin")
				.password(passwordEncoder.encode("admin"))
				.build();
		
		repo.saveAll(List.of(usuario, admin));
		
	}
}
