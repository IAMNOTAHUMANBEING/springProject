package com.example.testpjt.common.exception.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class urlDataNotFoundException extends RuntimeException {
    public urlDataNotFoundException(String url) {
        super(url);
    }
}
