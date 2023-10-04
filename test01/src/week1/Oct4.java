package com.mystudy.run;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Oct4 {

    public static void main(String[] args) throws Exception {
        // 1~10 합
        int sum = 0;
        for(int i=1;i<=10;i++){
            sum += i;
        }
        System.out.println("1~10의 합 : " + sum);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = 0;
        while(true) {
            System.out.print("원하는 단을 입력해주세요. : ");
            input = Integer.parseInt(br.readLine());
            if (input < 2 || input > 9) {
                System.out.println("2에서 9 사이의 숫자를 입력하세요.");
                continue;
            }
            break;
        }

        // input단 출력
        System.out.printf("=====%d단====\n", input);
        for(int j=1;j<=9;j++){
            System.out.printf("%2d X%2d = %2d\n", input, j, input*j);
        }
        System.out.println("============");
    }
}
