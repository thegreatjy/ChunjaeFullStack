package javaProblems.Chapter04;

// ch4 # 15
public class Palindrome {
    public static void main(String[] args) {
        // palindrome : 숫자를 거꾸로 읽어도 앞으로 읽는 것과 같은 수 (예 : 13531)
        int number = 565565;
        int tmp = number;
        int result = 0; // 변수 number를 거꾸로 변환해서 담을 변수

        while(tmp != 0) {
            // 1. 변환된 수의 각 자리수를 왼쪽으로 한 자리식 올린다.
            // 2. number의 일의 자리 수를 변환된 수에 더해준다.
            // 3. number의 일의 자리에 있는 수를 버림
            result = result * 10;
            result += tmp % 10;
            tmp = tmp / 10;
        }
        if(number == result)
            System.out.println( number + "는 회문수 입니다.");
        else
            System.out.println( number + "는 회문수가 아닙니다.");
    }
}
