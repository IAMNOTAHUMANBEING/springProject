package com.example.testpjt.service;

import com.example.testpjt.dto.MemberDTO;
import org.springframework.http.ResponseEntity;

public interface RestTemplateService {

    public String getrate1();

    public String getrate2();

    public String getrate3();

    public ResponseEntity<MemberDTO> postDto();

    public ResponseEntity<MemberDTO> addHeader();

}