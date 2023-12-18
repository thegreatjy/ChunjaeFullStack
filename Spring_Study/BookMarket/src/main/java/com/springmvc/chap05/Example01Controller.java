package com.springmvc.chap05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Example01Controller {
    @RequestMapping(value="/exam011", method= RequestMethod.GET)
    public void requestMethod(){
        System.out.println("@Controller 예제");
    }

    @RequestMapping(value="/member2", method= RequestMethod.GET)
    public void requestMethod2(){
        System.out.println("@Controller 2 예제");
    }
}
