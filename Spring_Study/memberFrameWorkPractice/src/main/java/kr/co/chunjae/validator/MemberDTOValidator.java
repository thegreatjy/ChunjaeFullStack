package kr.co.chunjae.validator;

import kr.co.chunjae.domain.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

// jsr-380 + spring validator
@Component
public class MemberDTOValidator implements Validator {
    // jsr-380 연동
    @Autowired
    private javax.validation.Validator beanValidator;
    // spring validator
    private Set<Validator> springValidators;

    // 생성자
    public MemberDTOValidator(){
        springValidators = new HashSet<>();
    }

    public void setSpringValidators(Set<Validator> springValidators){
        this.springValidators = springValidators;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MemberDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberDTO memberDTO = (MemberDTO) target;
        
        // jsr-380 beanValidator
        Set<ConstraintViolation<Object>> violations = beanValidator.validate(target);
        for(ConstraintViolation<Object> violation : violations){
            // 오류 발생 필드 저장
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage(); // 오류 발생 메세지 저장
            // 오류 발생된 필드와 메세지를 Errors 객체에 저장
            errors.rejectValue(propertyPath, "", message);
        }

        // spring validator
        for(Validator validator: springValidators){
            validator.validate(target, errors); // 발생된 오류 정보를 전달
        }

    }
}
