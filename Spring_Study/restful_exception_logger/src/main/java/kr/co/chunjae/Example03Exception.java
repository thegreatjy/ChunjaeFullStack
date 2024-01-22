package kr.co.chunjae;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("serial")
public class Example03Exception extends RuntimeException{
    private String errMsg;

    public Example03Exception() {
        super();
        this.errMsg = "Example03Exception 메세지입니다.";
    }
}
