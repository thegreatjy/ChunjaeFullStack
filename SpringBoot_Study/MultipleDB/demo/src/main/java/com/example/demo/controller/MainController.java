package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MainController {
    @GetMapping("/")
    public HashMap index(){
        // 주로 현재 서버가 살아있는지 여부를 반환한다.
        HashMap result = new HashMap();
        result.put("status", "UP");
        return result;
    }
}
