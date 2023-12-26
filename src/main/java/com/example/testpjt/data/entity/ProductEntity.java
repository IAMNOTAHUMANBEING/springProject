package com.example.testpjt.data.entity;

import com.example.testpjt.data.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity {
    @Id
    String productId;

    String productName;

    Integer productPrice;

    Integer productStock;

    public ProductDto toDto(){
        return ProductDto.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}
