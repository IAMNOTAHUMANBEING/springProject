package com.example.testpjt.controller;

import com.example.testpjt.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/post-api")
public class PostController {

    //body가 없어도 가능은 하지만 의미없음
    @PostMapping(value = "/default")
    public String postMethod() {
        return "Hello World!";
    }

    // {
    //  "name":"1",
    //  "email":"2",
    //  "oranization":"3"
    //}
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
