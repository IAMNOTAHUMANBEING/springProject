package com.example.testpjt.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NaverUriDto {

    private String message;

    private String code;

    private Result result;

    // static 붙이는 이유? -> ShortUrlServiceImpl에서 result getter 쓰기 위해
    @Getter
    @Setter
    public static class Result{

        private String Hash;

        private String url;

        private String orgUrl;
    }
}
