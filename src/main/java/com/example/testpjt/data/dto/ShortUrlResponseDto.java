package com.example.testpjt.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShortUrlResponseDto {

    private String orgUrl;

    private String shortUrl;
}
