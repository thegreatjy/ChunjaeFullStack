package kr.co.chunjae.startspringboot.domain;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Getter
@Slf4j
public class CustomExceptionTemp extends RuntimeException{
    private HttpStatus httpStatus;
    private String message;

    public CustomExceptionTemp (HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
