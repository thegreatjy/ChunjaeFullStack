package javaProblems.Chapter6;

public class ClassifyNumber {
    static boolean isNumber(String str){
        /*주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다.
        모두 숫자로만 이루어져 있으면 true를 반환하고,
        그렇지 않으면 false를 반환한다.
        만일 주어진 문자열이 null이거나 빈문자열“”이라면 false를 반환한다.*/
        if(str == null || str == "" || str.length() == 0)   return false;

        boolean result = true;
        for(char c:str.toCharArray()){
            if(c-'0' >= 0 && c-'0' <=9){
                continue;
            }else{
                result = false;
                break;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String str = "12345";
        System.out.println(str+"는 숫자입니까? "+isNumber(str));
        str = "12340o";
        System.out.println(str+"는 숫자입니까? "+isNumber(str));
    }
}
