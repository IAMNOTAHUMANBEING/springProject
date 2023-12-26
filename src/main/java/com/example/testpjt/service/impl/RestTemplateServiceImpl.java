package com.example.testpjt.service.impl;

import com.example.testpjt.dto.MemberDTO;
import com.example.testpjt.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

    @Override
    public String getrate1() {
        URI uri = UriComponentsBuilder
                .fromUriString("https://api.manana.kr")
                .path("/exchange/price/KRW/1/KRW,USD,JPY.json")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getrate2() {

        URI uri = UriComponentsBuilder
                .fromUriString("https://api.manana.kr")
                .path("/exchange/price.json")
                .queryParam("base","KRW")
                .queryParam("price","1")
                .queryParam("code","KRW,USD,JPY")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getrate3() {
        URI uri = UriComponentsBuilder
                .fromUriString("https://api.manana.kr")
                .path("/exchange/price/KRW/1/KRW,USD,JPY.{extension}")
                .encode()
                .build()
                .expand("json") // 복수의 값을 넣어야할 경우 , 를 추가하여 구분
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    //https://beeceptor.com/
    @Override
    public ResponseEntity<MemberDTO> postDto() {
        URI uri = UriComponentsBuilder
                .fromUriString("https://hitest.free.beeceptor.com")
                .path("/post")
                .encode()
                .build()
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("kim");
        memberDTO.setEmail("h@h");
        memberDTO.setOrganization("tech");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.postForEntity(uri, memberDTO, MemberDTO.class);
        LOGGER.info("hi");
        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("hi");
        LOGGER.info("body : {}", responseEntity.getBody());
        LOGGER.info("hi");
        return responseEntity;
    }

    //https://beeceptor.com/
    @Override
    public ResponseEntity<MemberDTO> addHeader() {
        URI uri = UriComponentsBuilder
                .fromUriString("https://hitest.free.beeceptor.com")
                .path("/post")
                .encode()
                .build()
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("kim");
        memberDTO.setEmail("h@h");
        memberDTO.setOrganization("tech");

        RequestEntity<MemberDTO> requestEntity = RequestEntity
                .post(uri)
                .header("testpjt-header", "new header")
                .body(memberDTO);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.exchange(requestEntity,
                MemberDTO.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }
}
