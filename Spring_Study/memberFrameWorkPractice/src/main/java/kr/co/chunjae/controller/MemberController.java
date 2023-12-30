package kr.co.chunjae.controller;

import kr.co.chunjae.domain.MemberDTO;
import kr.co.chunjae.validator.MemberDTOMobileValidator;
import kr.co.chunjae.service.MemberService;
import kr.co.chunjae.validator.MemberDTOValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    // 유효성 검사 validator 구현 객체
    @Autowired
    private MemberDTOValidator memberDTOValidator;

    // 회원가입
    @GetMapping("/save")
    public String saveForm(Model model){
        MemberDTO memberDTO = new MemberDTO();
        model.addAttribute("member", memberDTO);
        return "save";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("member") MemberDTO memberDTO, BindingResult errors, Model model){
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
            return "redirect:/member/main";
        }else{
            return "login";
        }
    }

    // 로그인 성공 후 화면
    @GetMapping("/main")
    public String mainForm(){
        return "main";
    }

    // jsr-380 + spring validator
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setValidator(memberDTOValidator);
    }


    // 회원 목록 조회
    @GetMapping("/list")
    public String findAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    // 회원 상세 조회
    @RequestMapping
    public String findById(@RequestParam("id") String id, Model model){
        int idInt = Integer.parseInt(id);

        MemberDTO memberDTO = memberService.findById(idInt);
        model.addAttribute("member", memberDTO);
        return "detail";
    }

    // 회원 삭제
    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id){
        int idInt = Integer.parseInt(id);

        memberService.delete(idInt);
        return "redirect:/member/list";
    }

    // 회원 정보 수정
    @GetMapping("/update")
    public String updateForm(Model model, HttpSession session){
        // 로그인 된 회원 정보를 가져온다.
        String email = (String) session.getAttribute("loginEmail");

        // 이메일을 통해 회원 정보를 가져온다.
        MemberDTO memberDTO = memberService.findByEmail(email);
        model.addAttribute("member", memberDTO);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("member") MemberDTO memberDTO, BindingResult errors){
        log.info(errors);

        if(errors.hasErrors()){
            return "update";
        }

        boolean result = memberService.update(memberDTO);
        if(result) {
            return "redirect:/member?id="+memberDTO.getId();
        }else{
            return "update";
        }
    }

}
