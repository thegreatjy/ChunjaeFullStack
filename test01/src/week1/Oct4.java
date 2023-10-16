package week1;

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

        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        */

        for(int k=0; k<2; k++){
            for(int j=1; j<=9; j++){
                for(int i=2+(k+4); i<5+(k+4); i++){
                    System.out.print(i+" X "+j+" = "+String.format("%2d", i*j));
                }
                System.out.println();
            }
            System.out.println();
        }

        String blank = " ";
        String star = "*";
        for(int i=0; i<7; i++){
            // 공백은 matrix 너비(7)의 절반 개수(7/2=3)부터 시작해서 하나씩 줄어간다.
            // 별은 1개부터 시작해서 양쪽으로 1개씩 늘어간다.
            // 별은 matrix 너비(7)에서 양쪽 공백을 제거한 개수만큼 출력
            int blankNum = Math.abs(7/2 - i);
            System.out.println(blank.repeat(blankNum) + star.repeat(7 - 2 * blankNum));
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("숫자를 입력하세요. : ");
        int input = Integer.parseInt(br.readLine());

        for(int i=0; i<input; i++){
            // 공백은 matrix 너비의 절반 개수부터 시작해서 하나씩 줄어간다.
            // 별은 1개부터 시작해서 양쪽으로 1개씩 늘어간다.
            // 별은 matrix 너비에서 양쪽 공백을 제거한 개수만큼 출력
            int blankNum = Math.abs(input/2 - i);
            System.out.println(blank.repeat(blankNum) + star.repeat(input - 2*blankNum));
        }
    }
}
