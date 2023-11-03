package monthlyTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseTriangle {
    public static void main(String[] args) throws Exception {
        // 입력
        System.out.print("삼각형의 높이를 입력하시오: ");
        String numStr = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int num = Integer.parseInt(numStr); // 삼각형 높이
        // 출력
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<num; i++){
            // blank space
            for(int b=0; b<i; b++){
                sb.append(" ");
            }
            // star
            for(int s=0; s<2*(num-i)-1; s++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
