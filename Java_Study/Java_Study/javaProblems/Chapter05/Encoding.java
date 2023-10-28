package javaProblems.Chapter05;

// Ch 5 # 10
public class Encoding {
    public static void main(String[] args) {
        char[] abcCode =
                { '`','~','!','@','#','$','%','^','&','*',
                        '(',')','-','_','+','=','|','[',']','{',
                        '}',';',':',',','.','/'};
// 0 1 2 3 4 5 6 7 8 9
        char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
        String src = "abc123";
        String result = "";
// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
        for(int i=0; i < src.length();i++) {
            char ch = src.charAt(i);

            if(ch >= 'a' && ch <= 'z')
                result = result.concat(""+abcCode[ch - 'a']);
            else if(ch >= '0' && ch <= '9')
                result = result.concat(""+numCode[ch - '0']);
        }
        System.out.println("src:"+src);
        System.out.println("result:"+result);
    }
}
