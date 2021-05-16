package com.devsuperior.dscatalog.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.entities.Category;

@RestController                         // Annotation que transforma a classe em controlador Rest
@RequestMapping(value="/categories")    // Criar rota do recurso Rest 
public class CategoryResource {         // Implementa o controlador Rest (RECURSOS)
	
	@GetMapping                         // Define o Método como um Endpoint (Webservice)
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = new ArrayList<>();
		list.add(new Category(1L, "Books"));
		list.add(new Category(2L, "Electronics"));
		return ResponseEntity.ok().body(list);
		
	}
	
	
		
}
