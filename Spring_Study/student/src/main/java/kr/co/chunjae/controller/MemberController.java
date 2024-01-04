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
import java.lang.reflect.Member;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Log4j2
public class MemberController {
    private final MemberService memberService;

    // 커스텀 로그인 화면
    @GetMapping("/customlogin")
    public String customLoginForm(String error, String logout, Model model){
        log.info("hereeeeeeeee");
        log.info(error);
        log.info(logout);

        if(error != null){
            model.addAttribute("error", "login error");
        }

        if (logout != null) {
            model.addAttribute("logout", "logout");
        }
        return "customlogin";
    }


    // 접근 제한 된 화면
    @GetMapping("/test")
    public String testtest(){
        return "testtest";
    }

    @GetMapping("/loginerror")
    public String errorForm(String error, String logout, Model model){
        log.info(error);
        log.info(logout);

        if(error != null){
            model.addAttribute("error", "login error");
        }

        if (logout != null) {
            model.addAttribute("logout", "logout");
        }
        return "customlogin";
    }


    // 회원가입
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

    // 로그인
    @GetMapping("/login")
    public String loginForm(Model model){
        MemberDTO memberDTO = new MemberDTO();
        model.addAttribute("memberDTO", memberDTO);
        return "login";  // save.jsp
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("memberDTO") MemberDTO memberDTO, HttpSession session, Model model){
        boolean loginResult = memberService.login(memberDTO);
        System.out.println(loginResult);
        if(loginResult){ // 정상
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            return "main";
        }else{  // 에러
            model.addAttribute("error", "다시 시도해 주세요.");
            return "login";
        }
    }

    // 모든 회원 조회
    @GetMapping("/")
    public String findAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    // 아이디로 회원 한 명 조회
    // /member?id=**
    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model){
        log.info(id);
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }

    // 회원 삭제
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        boolean deleteResult = memberService.delete(id);
        return "redirect:/member/";
    }

    // 회원정보 수정
    @GetMapping("/update")
    public String updateForm(Model model, HttpSession session){
        // 세션에 저장된 이메일을 통해 회원 정보를 가져옴
        String loginEmail = (String) session.getAttribute("loginEmail");
        MemberDTO memberDTO = memberService.findByMemberEmail(loginEmail);

        model.addAttribute("member", memberDTO);

        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("member")MemberDTO memberDTO){
        boolean resultUpdate = memberService.update(memberDTO);

        if(resultUpdate){
            return "redirect:/member?id="+memberDTO.getId();
        }else{
            return "index";
        }
    }

    @PostMapping("/email-check")
    public @ResponseBody String emailCheck(@RequestParam("memberEmail") String memberEmail){
        String checkResult = memberService.emailCheck(memberEmail);
        return checkResult;
    }
}
