package com.example.demo.controller;

import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public HashMap list(){
        /*
        List boardList = boardService.list();

        HashMap result = new HashMap();
        result.put("status", "200");
        result.put("datas", boardList);
        */
        return boardService.list();
    }

    @GetMapping("/write")
    public HashMap write(){
        return boardService.write();
    }
}
