package com.example.testpjt.service;

import com.example.testpjt.data.dto.ProductDto;
import org.springframework.stereotype.Service;

public interface ProductService {

    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

    ProductDto getProduct(String productId);
}
