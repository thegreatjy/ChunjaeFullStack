package kr.co.chunjae.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class MemberDTO {
    @NotNull
    @Size(min=1, max=50)
    @Pattern(regexp = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    private String email;
    @Size(min=1, max=50, message = "1자 이상 50자 이하를 입력해 주세요.")
    private String password;
    @Size(min=1, max=30)
    private String name;
    @Min(value=1)
    private int age;
    @Size(max=30)
    private String mobile;
}
