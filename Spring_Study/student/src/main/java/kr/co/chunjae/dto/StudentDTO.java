package kr.co.chunjae.dto;

import kr.co.chunjae.validator.UniqueStudentNumber;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.checkerframework.common.aliasing.qual.Unique;
import org.hibernate.validator.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@ToString
public class StudentDTO {
    private int id;
    @NotNull
    @UniqueStudentNumber(message = "{UniqueStudentNumber.Student.studentNumber}")
    @Min(0)
    private int studentNumber; // 학번
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
    @NotNull
    private int studentGender;
}
