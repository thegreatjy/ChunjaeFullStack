package kr.co.chunjae.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {
    private int id;
    private String studentName;
    private int studentKoreanScore;
    private int studentEnglishScore;
    private int studentMathScore;
}
