package com.example.testpjt.data.dto;

import com.example.testpjt.data.entity.ProductEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {

    @NotNull
    private String productId;

    @NotNull
    private String productName;

    @NotNull
    @Min(value = 500)
    @Max(value = 3000000)
    private int productPrice;

    @NotNull
    @Min(value = 0)
    @Max(value = 9999)
    private int productStock;

    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}
