package kr.co.chunjae;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class Example02Controller {
    @RequestMapping("/json")
    public String requestMethod(Model model){
        return "webpage14_02";
    }

    @PostMapping("/test")
    public void submit(@RequestBody HashMap<String, Object> map){
        System.out.println(map);
    }

    @GetMapping("/exam02")
    public @ResponseBody Person submit(){
        Person person = new Person();

        person.setName("HolGinDong");
        person.setAge("20");
        person.setEmail("Hong@naver.com");

        return person;
    }
}
