package com.example.testpjt.controller;

import com.example.testpjt.dto.MemberDTO;
import com.example.testpjt.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest-template")
public class RestTemplateController {

    RestTemplateService restTemplateService;

    @Autowired
    public RestTemplateController(RestTemplateService restTemplateService){
        this.restTemplateService = restTemplateService;
    }

    @GetMapping(value = "/fixedUri")
    public String getrate1(){
        return restTemplateService.getrate1();
    }

    @GetMapping(value = "/useQueryparam")
    public String getrate2() {
        return restTemplateService.getrate2();
    }

    @GetMapping(value = "/useVariable")
    public String getrate3() {
        return restTemplateService.getrate3();
    }

    @PostMapping(value = "/dto")
    public ResponseEntity<MemberDTO> postDto() {
        return restTemplateService.postDto();
    }

    @PostMapping(value = "/add-header")
    public ResponseEntity<MemberDTO> addHeader() {
        return restTemplateService.addHeader();
    }
}
