package kr.co.chunjae.startspringboot.controller;

import kr.co.chunjae.startspringboot.domain.CustomExceptionTemp;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
@Log4j2
@ControllerAdvice
public class ErrorControllerAdvice {
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(IOException.class)   // 처리하고 싶은 exception
    public String handle(IOException exception, HttpServletRequest request){
        log.info("@ControllerAdvice : IOException");
        return "error/error";
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(NullPointerException.class)   // 처리하고 싶은 exception
    public String handle(NullPointerException exception, HttpServletRequest request){
        log.info("@ControllerAdvice : NullPointerException");
        return "error/error";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomExceptionTemp.class)
    public String handle(CustomExceptionTemp exception, HttpServletRequest request){
        log.info("@ControllerAdvice : CustomExceptionTemp");
        return "error/error";
    }

}
