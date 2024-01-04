package kr.co.chunjae.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class StudentDTO {
    @NotNull
    @Min(0)
    private int studentId;
    @Min(0)
    private int studentNumber;
    @NotEmpty
    private String studentName;
    @Min(0)
    @Max(100)
    private int studentKoreanScore;
    @Min(0)
    @Max(100)
    private int studentEnglishScore;
    @Min(0)
    @Max(100)
    private int studentMathScore;
}
