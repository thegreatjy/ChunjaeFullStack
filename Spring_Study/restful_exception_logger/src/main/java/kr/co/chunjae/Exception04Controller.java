package kr.co.chunjae;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ControllerAdvice(basePackages={"com.springmvc"})
public class Exception04Controller {
    @ExceptionHandler(value={RuntimeException.class})
    public ModelAndView handelException(Exception exception){
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMessage", "Example04Exception 메세지입니다.");
        mav.addObject("exception", exception);
        mav.setViewName("webpage10_03");
        return mav;
    }
}
