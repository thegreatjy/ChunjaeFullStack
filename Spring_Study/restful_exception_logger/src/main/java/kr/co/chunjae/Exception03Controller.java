package kr.co.chunjae;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Exception03Controller {
    @GetMapping("/exception03")
    public void handleRequest(){
        throw new Example03Exception();
    }

    @ExceptionHandler(Example03Exception.class)
    public ModelAndView handelException(Example03Exception example03Exception){
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMessage", example03Exception.getErrMsg());
        mav.addObject("exception", example03Exception);
        mav.setViewName("webpage10_03");
        return mav;
    }
}
