package com.springmvc.chap07;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class Example04Controller {
    @GetMapping("/example04")
    public String showForm(Model model){
        model.addAttribute("member", new Member());
        return "webpage07_01";
    }

    @PostMapping("/example04")
    public String submitForm(@ModelAttribute Member member, Model model){
        model.addAttribute("member", member);
        return "webpage07_02";
    }

    @ModelAttribute("title")
    public String setTitle(){
        return "@ModelAttribute 유형";
    }

    @ModelAttribute
    public void setSubTitle(Model model){
        model.addAttribute("subtitle", "메서드에 @ModelAttribute 애너테이션 적용하기");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setAllowedFields("id", "password", "city", "sex");
    }
}
