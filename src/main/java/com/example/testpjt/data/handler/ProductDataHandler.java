package com.example.testpjt.data.handler;

import com.example.testpjt.data.entity.ProductEntity;

public interface ProductDataHandler {
    ProductEntity saveProductEntity(String prodcutId, String productName, int productPrice, int productStock);
    ProductEntity getProductEntity(String productId);
}
