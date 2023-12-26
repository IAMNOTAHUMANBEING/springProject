package com.example.testpjt.common.exception.exception;

import com.example.testpjt.common.exception.errorcode.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class urlNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;
}
