package kr.co.chunjae.validator;

import kr.co.chunjae.domain.MemberDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import javax.validation.ConstraintViolation;

// 전화번호 유효성 검사 - validator
@Component
@Log4j
public class MemberDTOMobileValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return MemberDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberDTO memberDTO = (MemberDTO) target;
        String mobile = memberDTO.getMobile();

        // 전화번호 형식 확인
        String pattern = "^\\d{2,3}-\\d{3,4}-\\d{4}$";

        if(mobile == null || !Pattern.matches(pattern, mobile)){
            errors.rejectValue("mobile", "mobile.not.available");
        }

    }
}
