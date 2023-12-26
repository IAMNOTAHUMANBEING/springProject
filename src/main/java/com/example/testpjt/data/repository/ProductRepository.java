package com.example.testpjt.data.repository;

import com.example.testpjt.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
