package com.example.testpjt.common.exception.handler;

import com.example.testpjt.common.exception.errorcode.CommonErrorCode;
import com.example.testpjt.common.exception.errorcode.ErrorCode;
import com.example.testpjt.common.exception.exception.urlDataNotFoundException;
import com.example.testpjt.common.exception.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class testpjtExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(testpjtExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleAllException(Exception e, WebRequest request) {

        LOGGER.warn("[handleAllException] : ", e);
        // 에러 코드를 커스텀 예외 클래스의 변수로 넣는 방법도 가능 어떤게 좋을까
        final ErrorCode errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR;

        return handleExceptionInternal(e, errorCode, new HttpHeaders(), errorCode.getHttpStatus(), request);
    }

    @ExceptionHandler(value = urlDataNotFoundException.class)
    public ResponseEntity<Object> handleUrlNotFoundException(urlDataNotFoundException e, WebRequest request) {

        LOGGER.warn("[handleUrlNotFoundException] : {}", e.getMessage());

        final ErrorCode errorCode = CommonErrorCode.RESOURCE_NOT_FOUND;

        return handleExceptionInternal(e, errorCode, new HttpHeaders(), errorCode.getHttpStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
         // 다른 핸들러 메서드에서 handleExceptionInternal를 호출하며 body로 null값을 주기 때문에 에러가 남
         // 어디서 쓰고 있는지도 모르는 함수를 오버라이딩 하는게 맞나
         // 차라리 오버로딩해서 내가 핸들러하고 있는 예외에만 적용하는게 맞는 거 같은데
         ErrorResponse errorResponse = makeErrorResponse((ErrorCode) body);

        return super.handleExceptionInternal(ex, errorResponse, headers, statusCode, request);
    }

    private ErrorResponse makeErrorResponse(final ErrorCode errorCode) {
        return ErrorResponse.builder()
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .build();
    }

//    @Override
//    private ResponseEntity<Object> handleExceptionInternal(final ErrorCode errorCode, final String message) {
//        return ResponseEntity.status(errorCode.getHttpStatus())
//                .body(makeErrorResponse(errorCode, message));
//    }

//    private ErrorResponse makeErrorResponse(final ErrorCode errorCode, final String message) {
//        return ErrorResponse.builder()
//                .code(errorCode.name())
//                .message(message)
//                .build();
//    }
}
