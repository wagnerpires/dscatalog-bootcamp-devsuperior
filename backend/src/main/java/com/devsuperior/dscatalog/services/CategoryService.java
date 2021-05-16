package com.devsuperior.dscatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;

@Service // Registra a classe como um componente que vai participar do sistema de injeção
			// de dependência automatizada gerenciada pelo Spring

public class CategoryService {

	@Autowired // Faz a instância ser gerenciada pelo Spring (Inj. de dependência)
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();

	}

}
