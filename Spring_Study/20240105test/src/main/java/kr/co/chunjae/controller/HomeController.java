package kr.co.chunjae.controller;

import kr.co.chunjae.domain.MemberDTO;
import kr.co.chunjae.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberService memberService;

    @GetMapping("/")
    public String requestMethod(Model model){
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(Model model){
        MemberDTO memberDTO = new MemberDTO();
        model.addAttribute("memberDTO", memberDTO);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("memberDTO") MemberDTO memberDTO, Model model, HttpSession session){
        boolean result = memberService.login(memberDTO);

        if(result){
            session.setAttribute("loginId", memberDTO.getId());
            return "main";
        }else{
            model.addAttribute("msg", "다시 시도해 주세요.");
            return "login";
        }
    }

    @GetMapping("/sample/member")
    public String test(){
        return "samplemember";
    }
}
