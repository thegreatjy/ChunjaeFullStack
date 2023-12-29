package kr.co.chunjae;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    private String name;
    private Integer age;
    private String email;
    private String mobile;
}
