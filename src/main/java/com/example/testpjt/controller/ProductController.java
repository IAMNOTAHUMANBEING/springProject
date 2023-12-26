package com.example.testpjt.controller;

import com.example.testpjt.data.dto.ProductDto;
import com.example.testpjt.service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] perform {} of TEST API", "getProduct");

        ProductDto productDto = productService.getProduct(productId);

        LOGGER.info("[ProductController] Response :: productID = {}, productName = {}, Response Time = {}ms",
                productDto.getProductId(), productDto.getProductName(), (System.currentTimeMillis() - startTime));

        return productDto;
    }


    @PostMapping(value = "/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {

        // Validation Code Other Example
        // if (productDto.getProductId().equals("") || productDto.getProductId().isEmpty()) {
        //     LOGGER.error("[createProduct] failed Response :: productId is Empty");
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDto);
        // }

        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStack = productDto.getProductStock();

        ProductDto response = productService.saveProduct(productId, productName, productPrice, productStack);

        LOGGER.info("[createProduct] Response >> productID = {}", response.getProductId());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

// testpjtException 삭제로 주석처리
//    @PostMapping(value = "/product/exception")
//    public void exceptionTest() throws testpjtException {
//        throw new testpjtException(ExceptionClass.PRODUCT, HttpStatus.BAD_REQUEST,
//                "의도한 에러가 발생");
//    }
}
