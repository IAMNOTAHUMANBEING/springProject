package com.example.testpjt.controller;


import com.example.testpjt.data.dto.ShortUrlResponseDto;
import com.example.testpjt.service.ShortUrlService;
import org.checkerframework.checker.units.qual.C;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/short-url")
public class ShortUrlController {

    private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlController.class);

    @Value("${testpjt.example.short.url.id}")
    private String CLIENT_ID;

    @Value("${testpjt.example.short.url.secret}")
    private String CLIENT_SECRET;

    ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService){
        this.shortUrlService = shortUrlService;
    }

    @GetMapping()
    public ShortUrlResponseDto getShortUrl(String originalUrl){

        LOGGER.info("[getShortUrl] perform API. CLIENT_ID = {}, CLIENT_SECRET = {}", CLIENT_ID, CLIENT_SECRET);
        return shortUrlService.getShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
    }

    @PostMapping()
    public ShortUrlResponseDto generateShortUrl(String originalUrl){

        LOGGER.info("[generateShortUrl] perform API. CLIENT_ID = {}, CLIENT_SECRET = {}", CLIENT_ID, CLIENT_SECRET);
        return shortUrlService.generateShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteShortUrl(String url){

        try{
            shortUrlService.deleteShortUrl(url);
        }catch (RuntimeException e){
            // 삭제할 값이 없는 경우 DB에서 Null Entity 반환받고 repository delete에 파라미터로 넘기면 예외발생
            LOGGER.info(e.toString());
        }

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다");
    }



}
