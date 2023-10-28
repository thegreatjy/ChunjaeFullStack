package week3.ch15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BoardLombok {
    private String subject;
    private String content;
    private String writer;

}
