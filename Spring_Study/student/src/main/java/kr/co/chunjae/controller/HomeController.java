package kr.co.chunjae.controller;

import kr.co.chunjae.dto.StudentDTO;
import kr.co.chunjae.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final StudentService studentService;

    @GetMapping({"/", ""})
    public String index(Model model){
        System.out.println("here");
        ArrayList<StudentDTO> studentList = studentService.selectAll();
        model.addAttribute("studentList", studentList);
        return "index";
    }
}

