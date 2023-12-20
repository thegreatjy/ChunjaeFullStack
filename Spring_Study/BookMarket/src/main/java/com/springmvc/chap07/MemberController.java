package com.springmvc.chap07;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/m")
    public String showForm(Model model){
        Member member = new Member();

        System.out.println("@GetMapping() -----");
        System.out.println("아이디 : " + member.getId());

        model.addAttribute("member", member);
        return "webpage07_01";
    }
}
