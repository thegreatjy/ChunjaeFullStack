package kr.co.chunjae.startspringboot.controller;

import kr.co.chunjae.startspringboot.domain.CustomExceptionTemp;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j2
public class CustomExceptionController {
    // custom 예외 발생
    @GetMapping("find-member-info")
    public ResponseEntity<?> findMemberInfo(){
        throw new CustomExceptionTemp(HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다.");
    }

    // RuntimeException 예외 발생 -> CustomExceptionTemp 발생
    @GetMapping("find-member-info-2")
    public ResponseEntity<?> findMemberInfo_2(){
        try{
            log.info("강제 RuntimeException invoke > catch > 생성한 CustomException throw > advice가 처리");
            throw new RuntimeException();
        }catch(Exception e){
            throw new CustomExceptionTemp(HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다.");
            //
        }
    }

    // custom 예외 처리
    // findMemberInfo_2()에서 발생한 예외를 @ControllerAdvice보다 먼저 처리함
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(CustomExceptionTemp.class)
    public String handleCustomException(HttpServletRequest request, CustomExceptionTemp exceptionTemp){
        log.error("Catch Custom Exception = {}", exceptionTemp.getHttpStatus(), exceptionTemp.getMessage());
        return "index";
    }
}
