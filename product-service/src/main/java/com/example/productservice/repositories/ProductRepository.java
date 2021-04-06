package com.example.productservice.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.productservice.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
}
