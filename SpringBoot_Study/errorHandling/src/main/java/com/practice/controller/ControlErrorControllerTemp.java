package com.practice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControlErrorControllerTemp implements ErrorController {
    // /error 스프링에서 제공
    @GetMapping("/error")
    public String handError() throws Exception{
        return "error/error";
    }
}
