package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CalculatorExample {
    public static void main(String[] args) throws Exception {
        System.out.println("연산, 숫자, 숫자 순서대로 입력하세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int op1 = Integer.parseInt(line[1]), op2 = Integer.parseInt(line[2]);

        Calculator c = new Calculator();
        double result = 0;

        if(line[0].equals("+")){
            result = c.plus(op1, op2);
        }else if(line[0].equals("-")){
            result = c.subtract(op1, op2);
        }else if(line[0].equals("*")){
            result = c.multiply(op1, op2);
        }else if(line[0].equals("/")){
            result = c.divide(op1, op2);
        }

        if(result%1 == 0.0) // 정수
            System.out.println((int)result);
        else {  // 실수, 두 번째 자릿수에서 반올림
            result = Math.round(result * 100) / 100.0;
            System.out.println(result);
        }
    }
}
