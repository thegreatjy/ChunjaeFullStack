package kr.co.chunjae.controller;

import kr.co.chunjae.dto.MemberDTO;
import kr.co.chunjae.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/save")
    public String saveForm(){
        return "save";  // save.jsp
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        int saveResult = memberService.save(memberDTO);

        if(saveResult > 0){ // 정상
            return "login";
        }else{  // 에러
            return "save";
        }
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        boolean loginResult = memberService.login(memberDTO);

        if(loginResult){    // 로그인 성공
            // 세션에 로그인 정보 저장
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            return "main";
        }else{              // 로그인 실패
            return "login";
        }
    }

    @GetMapping("/")
    public String findAll(Model model){
        List<MemberDTO> list = memberService.findAll();
        model.addAttribute("memberList", list);
        return "list";
    }

    // /member?id=**
    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }

}
