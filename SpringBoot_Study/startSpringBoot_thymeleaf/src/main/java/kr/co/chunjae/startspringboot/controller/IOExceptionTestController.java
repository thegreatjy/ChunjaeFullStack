package kr.co.chunjae.startspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class IOExceptionTestController {
    @GetMapping("/make_io_exception")
    public void createIOException() throws IOException{
        throw new IOException();    // @ControllerAdvice 호출됨
    }

    @GetMapping("/make_nullpointer_exception")
    public void createNullPointerException() throws NullPointerException{
        throw new NullPointerException();
    }
}
