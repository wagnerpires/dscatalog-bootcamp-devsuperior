package com.devsuperior.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.services.CategoryService;

@RestController                         // Annotation que transforma a classe em controlador Rest
@RequestMapping(value="/categories")    // Criar rota do recurso Rest 
public class CategoryResource {         // Implementa o controlador Rest (RECURSOS)
	
	@Autowired // Injetar automaticamente a dependência
	private CategoryService service;
	
	@GetMapping                         // Define o Método como um Endpoint (Webservice)
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
		
}
