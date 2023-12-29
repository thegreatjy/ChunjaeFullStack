package kr.co.chunjae.controller;

import kr.co.chunjae.domain.MemberDTO;
import kr.co.chunjae.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    // 회원가입
    @GetMapping("/save")
    public String saveForm(Model model){
        MemberDTO memberDTO = new MemberDTO();
        model.addAttribute("member", memberDTO);
        return "save";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("member") MemberDTO memberDTO, Errors errors, Model model){
        // 유효성 검사 오류 결과 확인
        if(errors.hasErrors()){
            return "save";
        }

        int result = memberService.save(memberDTO);

        if(result == 1){ // 회원가입 성공
            return "redirect:/";
        }else{
            model.addAttribute("msg", "다시 시도해 주세요.");
            return "save";
        }

    }
    // 바인딩은 제일 처음 실행된다.
    @ModelAttribute("msg")
    public String setMsg(){
        return "회원가입 페이지";
    }


    // 로그인
    @GetMapping("/login")
    public String loginForm(Model model){
        MemberDTO memberDTO = new MemberDTO();
        model.addAttribute("member", memberDTO);
        return "login";
    }
    // 스프링 시큐리티 추가할 것!
    @PostMapping("/login")
    public String login(@ModelAttribute("member") MemberDTO memberDTO, HttpSession session){
        boolean result = memberService.login(memberDTO);

        if(result){ // 로그인 성공
            // 세션에 로그인된 이메일 저장
            session.setAttribute("loginEmail", memberDTO.getEmail());
            return "redirect:/";
        }else{
            return "login";
        }
    }

}
