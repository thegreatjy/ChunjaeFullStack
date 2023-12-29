package kr.co.chunjae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MemberController {
    @Autowired
    private MemberValidator memberValidator;

    @GetMapping("/member")
    public String memberForm(Model model){
        model.addAttribute("memberDTO", new MemberDTO());
        return "webpage13_01";
    }

    @PostMapping("/member")
    public String submit(@Valid @ModelAttribute MemberDTO memberDTO, BindingResult result){
        if(result.hasErrors()){
            return "webpage13_01";
        }
        return "webpage13_result";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(memberValidator);
    }
}
