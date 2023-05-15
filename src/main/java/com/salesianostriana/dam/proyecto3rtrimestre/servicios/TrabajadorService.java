package com.salesianostriana.dam.proyecto3rtrimestre.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Trabajador;
import com.salesianostriana.dam.proyecto3rtrimestre.repos.RepositorioTrabajador;

@Service
public class TrabajadorService implements UserDetailsService {
	@Autowired
	private RepositorioTrabajador repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repositorio.findFirstByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Error al buscar el usuario"));
	}
	
	public List<Trabajador> findAll() {
		return repositorio.findAll();
	}
	
	public Trabajador save(Trabajador t) {
		return repositorio.save(t);
	}
	
	public Trabajador findById(Long idTrabajador) {
		return repositorio.findById(idTrabajador).orElse(null);
	}
	
	public Trabajador delete(Trabajador t) {
		Trabajador result = findById(t.getIdTrabajador());
		repositorio.delete(result);
		return result;
	}
}
