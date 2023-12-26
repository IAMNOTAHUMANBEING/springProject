package com.example.testpjt.common.exception.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// valid exception 예제 때 필요(https://blog.naver.com/writer0713/221605253778)
@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {

    private final String code;
    private final String message;
}