package com.salesianostriana.dam.proyecto3rtrimestre;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyecto3rtrimestre.model.Cliente;
import com.salesianostriana.dam.proyecto3rtrimestre.model.ParteVehiculo;
import com.salesianostriana.dam.proyecto3rtrimestre.model.Vehiculo;
import com.salesianostriana.dam.proyecto3rtrimestre.repos.RepositorioCliente;
import com.salesianostriana.dam.proyecto3rtrimestre.repos.RepositorioParteVehiculo;
import com.salesianostriana.dam.proyecto3rtrimestre.repos.RepositorioVehiculo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainDeMentira {
	
	private RepositorioCliente repositorioCliente;
	private RepositorioVehiculo repositorioVehiculo;
	private RepositorioParteVehiculo repositorioParteVehiculo;
	
	@PostConstruct
	public void ejecutar() {
		Vehiculo v1 = new Vehiculo();
		Vehiculo v2 = new Vehiculo();
		
		v1.builder()
			.matricula("7742GTK")
			.bastidor("HASJ2LOSD2")
			.modelo("i30")
			.marca("HYUNDAI")
			.build();
		v2.builder()
			.matricula("9283JSH")
			.bastidor("AKFJW287JD")
			.modelo("812")
			.marca("MERCEDES")
			.build();
		
		repositorioVehiculo.save(v1);
		repositorioVehiculo.save(v2);
		
		Cliente c1= new Cliente();
		Cliente c2= new Cliente();
		
		c1.builder()
			.dni("928937647N")
			.nombre("Pepe")
			.apellidos("pepega")
			.telefono("847028374")
			.email("pepito@gmail.com")
			.fotoDni(null)
			.build();
		c1.builder()
			.dni("764310487S")
			.nombre("Antonio")
			.apellidos("Chusquero")
			.telefono("929764837")
			.email("freeAntonio@gmail.com")
			.fotoDni(null)
			.build();
		
		repositorioCliente.save(c1);
		repositorioCliente.save(c2);
		
		ParteVehiculo pv1= new ParteVehiculo();
		ParteVehiculo pv2= new ParteVehiculo();
		
		pv1.builder()
			.vehiculo(v1)
			.cliente(c1)
			.tiempoEmpleado(8)
			.fechaLlegada(LocalDateTime.now())
			.fechaSalida(LocalDateTime.now())
			.observaciones("El coche está bien, pero el tio es más feo que un diente suelto")
			.build();
		pv2.builder()
			.vehiculo(v2)
			.cliente(c2)
			.tiempoEmpleado(4)
			.fechaLlegada(LocalDateTime.now())
			.fechaSalida(LocalDateTime.now())
			.observaciones("Trocola partida y chicle del inyector de tránsito averiado")
			.build();
		
		repositorioParteVehiculo.save(pv1);
		repositorioParteVehiculo.save(pv2);
		
		System.out.println(pv1);
		System.out.println(pv2);
	}
}
