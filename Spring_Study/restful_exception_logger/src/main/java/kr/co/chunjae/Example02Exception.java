package kr.co.chunjae;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "찾을 수 없습니다.")
public class Example02Exception extends Exception {
    public Example02Exception(String message) {
        super(message);
        System.out.println(message);
    }
}
