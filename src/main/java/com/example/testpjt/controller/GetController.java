package com.example.testpjt.controller;

import com.example.testpjt.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @RequestMapping(value = "/hello")
    public String getHello() {
        return "Hello World!";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "My name";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    // 유지보수 용이하려고
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    //http://localhost:8080/api/v1/get-api/request1?name=haha&email=hoho&organization=kiki
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    //http://localhost:8080/api/v1/get-api/request2?name=haha&email=hoho&organization=kiki
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request3?name=haha&email=hoho&organization=kiki
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();
    }
}
