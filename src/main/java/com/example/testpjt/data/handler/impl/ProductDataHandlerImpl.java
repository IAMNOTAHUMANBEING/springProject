package com.example.testpjt.data.handler.impl;

import com.example.testpjt.data.dao.ProductDao;
import com.example.testpjt.data.entity.ProductEntity;
import com.example.testpjt.data.handler.ProductDataHandler;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {
    ProductDao productDao;

    @Autowired
    public ProductDataHandlerImpl(ProductDao productDao){
        this.productDao = productDao;
    }

    @Override
    public ProductEntity saveProductEntity(String prodcutId, String productName, int productPrice, int productStock){
        ProductEntity productEntity = new ProductEntity(prodcutId, productName, productPrice, productStock);

        return productDao.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId){
        return productDao.getProduct(productId);
    }
}
