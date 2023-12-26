package com.example.testpjt.service.impl;

import com.example.testpjt.data.dto.ProductDto;
import com.example.testpjt.data.entity.ProductEntity;
import com.example.testpjt.data.handler.ProductDataHandler;
import com.example.testpjt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStack){
        // Entity로 변환
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStack);

        // 다시 Dto로
        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(),
                productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId){
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);

        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(),
                productEntity.getProductPrice(), productEntity.getProductStock());

        return  productDto;
    }
}


