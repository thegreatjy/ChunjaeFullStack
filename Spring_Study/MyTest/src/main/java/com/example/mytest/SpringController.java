package com.example.mytest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/MyTest")
public class SpringController {
    @GetMapping
    public ModelAndView requestAllBooks(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "스프링 코딩 공작소");
        mav.addObject("name", "이지연");
        mav.setViewName("spring");
        return mav;
    }
}
