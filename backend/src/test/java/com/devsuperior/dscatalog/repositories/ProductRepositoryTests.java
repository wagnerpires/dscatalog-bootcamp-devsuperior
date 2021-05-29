package com.devsuperior.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    private long existId;
    private long nonExistingId;
    private long countTotalProducts;

    @BeforeEach
    void setUp() throws Exception {
        existId = 1L;
        nonExistingId = 1000L;
        countTotalProducts = 25L;
    }

    @Test
    public void saveShouldPersistWithAutoIncrementWhenIdIsNull() {

        Product product = Factory.createProduct();
        product.setId(null);

        product = repository.save(product);
        
        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(countTotalProducts + 1, product.getId());

    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {
        
    	repository.deleteById(existId);

        Optional<Product> result = repository.findById(existId);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }

    @Test
    public void findByIdShouldReturnNonEmptyOptionalWhenIdExists() {

        Optional<Product> result = repository.findById(existId);
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    public void findByIdShouldReturnEmptyOptionalWhenIdDoesNotExist() {

        Optional<Product> result = repository.findById(nonExistingId);
        Assertions.assertTrue(result.isEmpty());
    }


}
