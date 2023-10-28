package javaProblems.Chapter05;

import java.util.Scanner;

// Ch 5 # 13
public class MixedString {
    public static void main(String[] args) {
        String[] words = { "television", "computer", "mouse", "phone" };
        Scanner scanner = new Scanner(System.in);

        for(int i=0;i<words.length;i++) {
            char[] question = words[i].toCharArray(); // String을 char[]로 변환
            for(int j=0; j<question.length; j++){
                int rdm = (int)(Math.random()*words[i].length());

                char tmp = question[i];
                question[i] = question[rdm];
                question[rdm] = tmp;
            }


            System.out.printf("Q%d. %s의 정답을 입력하세요.>", i+1, new String(question));
            String answer = scanner.nextLine();

            if(words[i].equals(answer.trim()))
                System.out.printf("맞았습니다.%n%n");
            else
                System.out.printf("틀렸습니다.%n%n");
        }
    }
}
