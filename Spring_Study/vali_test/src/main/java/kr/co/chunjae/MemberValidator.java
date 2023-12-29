package kr.co.chunjae;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class MemberValidator implements Validator{
	 public boolean supports(Class<?> clazz) { 
	      return MemberDTO.class.isAssignableFrom(clazz);
	   }

	   public void validate(Object target, Errors errors) { 
		   MemberDTO memberDTO = (MemberDTO) target;

		   // 이름
	        String name = memberDTO.getName();
	        if(name == null || name.trim().isEmpty()) {
	            errors.rejectValue("name", "name.not.empty");
	        }
//	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "�������");
	        
        	// 나이
	        Integer age = memberDTO.getAge();
	        if(age == null) {
	           
	            errors.rejectValue("age", "age.not.inrange");
	        }
//	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "�������");
	        
	        // 이메일
	        String email = memberDTO.getEmail();
	        if(email == null || email.trim().isEmpty()) {
	           
	            errors.rejectValue("email", "email.not.correct");
	            errors.rejectValue("email", "email.not.empty");
	        }

			// 전화번호
		   String mobile = memberDTO.getMobile();
		   if(mobile == null || mobile.trim().isEmpty()) {

			   errors.rejectValue("mobile", "mobile.not.correct");
			   errors.rejectValue("mobile", "mobile.not.empty");
		   }
	    }
	  
}