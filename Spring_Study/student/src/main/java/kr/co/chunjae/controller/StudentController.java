package kr.co.chunjae.controller;

import kr.co.chunjae.dto.StudentDTO;
import kr.co.chunjae.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
@Log4j2
public class StudentController {
    private final StudentService studentService;


    // 학생등록
    @GetMapping("/insert")
    public String insertForm(Model model){
        StudentDTO studentDTO = new StudentDTO();
        model.addAttribute("StudentDTO", studentDTO);
        return "insert";
    }

    @PostMapping("/insert")
    public String insert(@Valid @ModelAttribute("StudentDTO") StudentDTO studentDTO, BindingResult errors){
        // 바인딩 시, 유효성 검사에 실패하면 insert 페이지로 돌아가 오류 메세지를 출력한다.
        log.info(errors);
        if(errors.hasErrors()){
            return "insert";
        }

        boolean insertResult = studentService.insert(studentDTO);
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
        model.addAttribute("StudentDTO", studentDTO);
        return "update";
    }

    @PostMapping("/score/update")
    public String update(@Valid @ModelAttribute StudentDTO studentDTO, BindingResult errors, Model model){
        // 국어, 영어, 수학 필드에 대한 에러만 에러 메세지를 출력한다.
        if(errors.hasFieldErrors("studentKoreanScore") || errors.hasFieldErrors("studentEnglishScore") || errors.hasFieldErrors("studentMathScore")){
            return "update";
        }

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
