package com.springmvc.chap06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Example03Controller {
    @GetMapping("/exam01/{bookId}")
    public String requestMethod(@PathVariable String bookId, Model model){
        System.out.println("도서 ID : " + bookId);
        model.addAttribute("data", "도서 ID : " + bookId);
        return "webpage06"; // webpage06.jsp
    }
}
