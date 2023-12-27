package kr.co.chunjae.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j
public class CommonController {
    @GetMapping("/accessError")
    public void accessDenied(Authentication auth, Model model){
        log.info("access Denied "+auth);

        model.addAttribute("msg", "access denied");
    }

    @GetMapping("/customLogin")
    public void loginInput(String error, String logout, Model model){
        log.info("error "+error);
        log.info("logout" + logout);

        if(error != null){
            model.addAttribute("error", "loginerror");
        }
        if(logout != null){
            model.addAttribute("logout", "logouterror");
        }
    }
}
