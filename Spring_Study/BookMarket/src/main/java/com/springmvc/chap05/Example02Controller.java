package com.springmvc.chap05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class Example02Controller {
    @RequestMapping("/register")
    public void requestMethod(){
        // exam02/exam03/request
        System.out.println("Example02Controller requestMethod");
    }

    @RequestMapping("/register2")
    public void requestMethod2(){
        // exam02/exam03/request
        System.out.println("exam02 request method /");
    }
}
