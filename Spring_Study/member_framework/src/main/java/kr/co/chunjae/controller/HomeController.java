package kr.co.chunjae.controller;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final SqlSessionTemplate sql;

    @GetMapping("/")
    public String index(Model model){
       String result = sql.selectOne("Member.test");
        model.addAttribute("time", result);
        System.out.printf(result);
        return "index";
    }
}

