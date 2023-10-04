package javaProblems.Chapter4;

// ch4 #13
public class CharOrInteger {
    public static void main(String[] args) {
        String value = "12o34";
        char ch = ' ';
        boolean isNumber = true;

        // 반복문과 charAt(int i)를 이용해서 문자열의 문자를
        // 하나씩 읽어서 검사한다.
        for (int i = 0; i < value.length(); i++) {
            // i번째에 있는 문자를 아스키 코드 값으로 변환
            int c = value.charAt(i) - ch;
            if(c >= 65 && c <= 90)      isNumber = false;   // 대문자
            else if(c >= 97 & c <= 122) isNumber = false;    // 소문자
        }

        if (isNumber) {
            System.out.println(value + "는 숫자입니다.");
        } else {
            System.out.println(value + "는 숫자가 아닙니다.");
        }
    }
}
