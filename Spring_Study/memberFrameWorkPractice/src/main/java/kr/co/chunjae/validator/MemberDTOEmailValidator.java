package kr.co.chunjae.validator;

import kr.co.chunjae.exception.MemberDTOEmailException;
import kr.co.chunjae.service.MemberService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@Log4j
public class MemberDTOEmailValidator implements ConstraintValidator<MemberValid, String> {
    @Autowired
    private MemberService memberService;

    public void initialize(MemberValid constraintAnnotation){ //@MemberValid 정보 초기화 메서드
    }

    // 유효성 검사 메서드
    public boolean isValid(String value, ConstraintValidatorContext context){
        boolean result = true;

        try{
            result = memberService.searchEmail(value);
        }catch (MemberDTOEmailException e){
            return true;
        }

        if(result){ // value값을 가진 이메일이 이미 존재한다
            return false;
        }else{
            return true;
        }
    }
}