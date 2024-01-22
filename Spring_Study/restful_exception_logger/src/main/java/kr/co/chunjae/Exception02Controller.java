package kr.co.chunjae;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class Exception02Controller {
    @GetMapping("/exception02")
    public void handleRequest() throws Exception{
        throw new Exception(new Example02Exception("Exception02 메세지 입니다."));
    }
}
