package kr.co.chunjae;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example {
    @GetMapping("/exam01")
    public String requestMethod(){
        return "webpage12_01";
    }

    @GetMapping("/exam02")
    public String requestMethod2(){
        return "webpage12_01";
    }

    @GetMapping("/exam03")
    public String requestMethod3(){
        return "webpage12_03";
    }
}
