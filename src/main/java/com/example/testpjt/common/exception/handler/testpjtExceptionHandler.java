package com.example.testpjt.common.exception.handler;

import com.example.testpjt.common.exception.errorcode.CommonErrorCode;
import com.example.testpjt.common.exception.errorcode.ErrorCode;
import com.example.testpjt.common.exception.exception.urlNotFoundException;
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

        final ErrorCode errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR;

        return handleExceptionInternal(e, errorCode, null, errorCode.getHttpStatus(), request);
    }

    @ExceptionHandler(value = urlNotFoundException.class)
    public ResponseEntity<Object> handleUrlNotFoundException(urlNotFoundException e, WebRequest request) {
        final ErrorCode errorCode = CommonErrorCode.RESOURCE_NOT_FOUND;
        return handleExceptionInternal(e, errorCode, null, errorCode.getHttpStatus(),request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
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
