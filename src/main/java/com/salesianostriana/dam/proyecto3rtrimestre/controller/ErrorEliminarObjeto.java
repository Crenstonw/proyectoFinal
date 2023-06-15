package com.salesianostriana.dam.proyecto3rtrimestre.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ErrorEliminarObjeto extends Exception {
	public static final long serialVersionUID = 1L;
	
	public ErrorEliminarObjeto() {
		
	}
	
	public ErrorEliminarObjeto(String msg) {
		super(msg);
	}
	
	public void temp() throws ErrorEliminarObjeto {
		throw new ErrorEliminarObjeto("Este objeto esta siendo usado");
	}
}
