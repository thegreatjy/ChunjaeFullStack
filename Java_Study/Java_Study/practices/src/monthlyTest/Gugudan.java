package monthlyTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gugudan {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        System.out.print("원하는 단을 입력하시오. : ");
        int input = Integer.parseInt(br.readLine());

        // 결과 출력
        System.out.println("==========");
        for(int i=1; i<10; i++){
            System.out.println(input + " * " + i +" = " + input*i);
        }
        System.out.println("==========");
    }
}
