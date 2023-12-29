package kr.co.chunjae.controller;

import kr.co.chunjae.domain.MemberDTO;
import kr.co.chunjae.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String save(@ModelAttribute("member") MemberDTO memberDTO, Model model){
        log.info(memberDTO);
        int result = memberService.save(memberDTO);
        log.info(result);

        if(result == 1){ // 회원가입 성공
            return "redirect:/";
        }else{
            model.addAttribute("msg", "다시 시도해 주세요.");
            return "save";
        }

    }

    @ModelAttribute("msg")
    public String setMsg(){
        return "회원가입 페이지";
    }
}
