package com.practice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping("/statistics")
@RequiredArgsConstructor
@Slf4j
public class StatisticController {
    @GetMapping("/check/exception")
    @ExceptionHandler(value = Exception.class)
    public String whtToDoException() throws Exception{
        // ...
        return "notfound";
    }

    @GetMapping("/check/time-out")
    @ExceptionHandler(value = {TimeoutException.class})
    public String notFoundException() throws Exception{
        // ...
        return "timeoutException";
    }
}
