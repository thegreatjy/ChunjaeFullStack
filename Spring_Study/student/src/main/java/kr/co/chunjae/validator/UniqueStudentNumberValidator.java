package kr.co.chunjae.validator;

import kr.co.chunjae.service.StudentService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueStudentNumberValidator implements ConstraintValidator<UniqueStudentNumber, Integer> {
    private final StudentService studentService;

    @Override
    public void initialize(UniqueStudentNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if(studentService.searchStudentNumber(integer.intValue())){ // 존재하는 학번
            return false;
        }else{
            return true;
        }
    }
}
