package kr.co.chunjae;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class Exception01Controller {
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "하츄핑의 분노")
    @GetMapping("/exception01")
    public String requestMethod(Model model){
        System.out.println("chapter 10 - 1 예제입니다.");
        model.addAttribute("data", "@ResponseStatus 처리 예제입니다.");
        return "webpage10_01";
    }
}
