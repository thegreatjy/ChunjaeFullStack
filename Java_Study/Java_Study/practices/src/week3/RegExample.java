package week3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExample {


    public static void main(String[] args) {
        String pattern = "^[0-9]*$"; //숫자만
        String val = "123456789"; //대상문자열

        System.out.println(Pattern.matches(pattern, val));


        Pattern patternn = Pattern.compile("^[a-zA-Z]*$"); //영문자만
        String val2 = "abcdef"; //대상문자열

        Matcher matcher = patternn.matcher(val2);
        System.out.println(matcher.find());

        Pattern pat = Pattern.compile("^[a-zA-Z]*$");
        String name = "thethe";

        Matcher matcher1 = pat.matcher(name);
        System.out.println(matcher1.find());



    }
}
