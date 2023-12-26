package com.example.testpjt.data.dao.impl;

import com.example.testpjt.data.dao.ProductDao;
import com.example.testpjt.data.entity.ProductEntity;
import com.example.testpjt.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDaoImpl implements ProductDao {

    ProductRepository productRepository;

    @Autowired
    public ProductDaoImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity){
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId){
        // getById와 FindById차이(https://passionfruit200.tistory.com/386)
        ProductEntity productEntity = productRepository.getReferenceById(productId);
        return productEntity;
    }
}
