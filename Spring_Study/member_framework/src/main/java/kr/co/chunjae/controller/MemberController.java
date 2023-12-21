package kr.co.chunjae.controller;

import kr.co.chunjae.dto.MemberDTO;
import kr.co.chunjae.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Log4j2
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
        System.out.println("controller");
        return "login";  // save.jsp
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        boolean loginResult = memberService.login(memberDTO);
        System.out.println(loginResult);
        if(loginResult){ // 정상
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            return "main";
        }else{  // 에러
            return "login";
        }
    }

    @GetMapping("/")
    public String findAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    // /member?id=**
    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model){
        log.info(id);
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }
}
