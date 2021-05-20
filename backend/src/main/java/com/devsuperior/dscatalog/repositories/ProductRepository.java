package com.devsuperior.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.Product;

@Repository                 //Registrar como um componente injetável do mecanismo de injeção de dependência do Spring
public interface ProductRepository extends JpaRepository<Product, Long> {

}
