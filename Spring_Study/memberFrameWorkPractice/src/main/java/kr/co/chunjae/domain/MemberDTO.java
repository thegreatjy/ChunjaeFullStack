package kr.co.chunjae.domain;

import kr.co.chunjae.validator.MemberValid;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class MemberDTO {
    private int id;
    @MemberValid // 사용자 정의 애너테이션 - 이메일 중복 검사
    @Pattern(regexp = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "{Pattern.member.email}")
    @NotEmpty(message = "{NotEmpty.member.email}")
    private String email;
    @Size(min=1, max=50, message = "1자 이상 50자 이하를 입력해 주세요.")
    private String password;
    @Size(min=1, max=30, message = "{Size.member.name}")
    private String name;
    @Min(value=1, message = "{Min.member.age}")
    private int age;
    @Size(max=30, message = "{Size.member.mobile}")
    private String mobile;
}
