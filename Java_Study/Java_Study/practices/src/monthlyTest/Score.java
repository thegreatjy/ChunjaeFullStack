package monthlyTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Score {
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("점수를 입력하시오. : ");
        int score = Integer.parseInt(br.readLine()); // 점수

        // switch
        switch (score/10){
            // 90 이상 100 이하 = A
            case 10:
            case 9:
                System.out.println("A");
                break;
            // 80 이상 89 이하 = B
            case 8:
                System.out.println("B");
                break;
            // 70 이상 79 이하 = C
            case 7:
                System.out.println("C");
                break;
            // 60 이상 69 이하 = D
            case 6:
                System.out.println("D");
                break;
            // 59 이하 F
            default:
                System.out.println("F");
        }


    }
}
