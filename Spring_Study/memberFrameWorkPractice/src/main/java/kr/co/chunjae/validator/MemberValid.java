package kr.co.chunjae.validator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 이메일 중복 검사 사용자 애너테이션
@Constraint(validatedBy = MemberDTOEmailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MemberValid {
    String message() default "{MemberValid.member.email}";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
