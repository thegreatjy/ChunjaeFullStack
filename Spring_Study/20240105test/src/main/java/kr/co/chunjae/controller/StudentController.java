package kr.co.chunjae.controller;

import kr.co.chunjae.domain.StudentDTO;
import kr.co.chunjae.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Log4j
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    // 학점 관리 페이지 : 학생 목록 조회
    @GetMapping("/list")
    public String listForm(Model model){
        List<StudentDTO> studentList = studentService.selectAll();
        model.addAttribute("studentList", studentList);
        return "list";
    }

    // 학생 성적 등록
    @GetMapping("/insert")
    public String insertForm(Model model){
        StudentDTO studentDTO = new StudentDTO();
        model.addAttribute("studentDTO", studentDTO);
        return "insert";
    }

    @PostMapping("/insert")
    public String insert(@Valid @ModelAttribute("studentDTO")StudentDTO studentDTO, BindingResult errors){
        if(errors.hasErrors()){
            return "insert";
        }

        boolean result = studentService.insert(studentDTO);
        if(result){
            return "redirect:/student/list";
        }else{
            return "insert";
        }
    }

    // 학생 성적 수정
    ///student/update?studentId=${student.studentId}
    @GetMapping("/update")
    public String updateForm(@RequestParam("studentId") int studentId, Model model){
        StudentDTO studentDTO = studentService.selectByStudentId(studentId);
        model.addAttribute("studentDTO", studentDTO);
        return "update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("studentDTO") StudentDTO studentDTO, BindingResult errors){
        if(errors.hasFieldErrors("studentKoreanScore") || errors.hasFieldErrors("studentEnglishScore") || errors.hasFieldErrors("studentMathScore")){
            return "update";
        }

        studentService.update(studentDTO);
        return "redirect:/student/list";
    }

    // 학생 삭제
    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int studentId, Model model){
        studentService.delete(studentId);
        return "redirect:/student/list";
    }
}
