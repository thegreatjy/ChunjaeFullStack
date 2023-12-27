package kr.co.chunjae.controller;

import kr.co.chunjae.dto.StudentDTO;
import kr.co.chunjae.service.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    // 학생등록
    @GetMapping("/insert")
    public String insertForm(){
        return "insert";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute StudentDTO studentDTO){
        boolean insertResult = studentService.insert(studentDTO);
        System.out.println("insert : "+insertResult);
        if(insertResult){   // 정상
            return "redirect:/";
        }else{  // 오류
            return "redirect:/student/insert";
        }
    }

    // 점수 정정
    @GetMapping("/score/update")
    public String updateForm(@RequestParam Integer id, Model model){
        int intId = id.intValue();
        StudentDTO studentDTO = studentService.select(intId);
        model.addAttribute("student", studentDTO);
        return "update";
    }

    @PostMapping("/score/update")
    public String update(@ModelAttribute StudentDTO studentDTO, Model model){
        boolean updateResult = studentService.update(studentDTO);
        if(updateResult){   // 정상
            return "redirect:/student/score/update?id=" + studentDTO.getId();
        }else{  // 오류
            return "redirect:/";
        }
    }

    // 학생 삭제
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        int intId = id.intValue();
        studentService.delete(intId);
        return "redirect:/";
    }

    // 학번으로 찾기
    @PostMapping("/search")
    public String searchById(@ModelAttribute("id") String id, Model model){
        System.out.println(id);
        int intId = Integer.parseInt(id);
        System.out.println(intId);
        StudentDTO studentDTO = studentService.select(intId);
        ArrayList<StudentDTO> studentList = new ArrayList<>();
        studentList.add(studentDTO);
        model.addAttribute("studentList", studentList);
        return "index";
    }
}
