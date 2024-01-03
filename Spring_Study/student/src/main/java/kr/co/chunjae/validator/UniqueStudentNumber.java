package kr.co.chunjae.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqueStudentNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueStudentNumber {
    String message() default "{UniqueStudentNumber.Student.studentNumber}";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
