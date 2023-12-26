package com.example.testpjt.controller;

import com.example.testpjt.TestpjtApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @PostMapping("/log_test")
    public void logTest(){

        LOGGER.trace("Trace LOG");
        LOGGER.debug("Debug LOG");
        LOGGER.info("Info LOG");
        LOGGER.warn("Warn LOG");
        LOGGER.error("Error LOG");
    }

    @PostMapping("/exception")
    public void exceoptionTest() throws Exception {
        throw new Exception();
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e){
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info(e.getMessage());
        LOGGER.info("Controller 내 ExceptionHandler 호출");

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
}
