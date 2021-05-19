package com.devsuperior.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.services.CategoryService;

@RestController // Annotation que transforma a classe em controlador Rest
@RequestMapping(value = "/categories") // Criar rota do recurso Rest
public class CategoryResource { // Implementa o controlador Rest (RECURSOS)

	@Autowired // Injetar automaticamente a dependência da classe CategoryService
	private CategoryService service;

	@GetMapping // Define o Método como um Endpoint (Webservice)
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // Busca a categoria pelo Id
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) { // Annotation que faz com que a variável passada na roda case com o parametro do método
		CategoryDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
 

}
