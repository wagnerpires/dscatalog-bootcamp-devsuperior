package com.devsuperior.dscatalog.services.exceptions;

public class ResourceyNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceyNotFoundException(String msg) {
		super(msg); // Repassar o argumento para o construtor da superclasse
	}
}
