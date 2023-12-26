package com.example.testpjt.data.dao;

import com.example.testpjt.data.entity.ProductEntity;

public interface ProductDao {
    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity getProduct(String productId);
}
