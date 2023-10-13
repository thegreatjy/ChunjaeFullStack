package javaProblems.Chapter4;

// ch4 # 14
public class RandomIntegerGame {
    public static void main(String[] args) {
        // 1~100까지의 랜덤 정수를 생성항 answer에 저장
        int answer = (int)(Math.random()*100);
        int input = 0; // 사용자입력을 저장할 공간
        int count = 0; // 시도횟수를 세기위한 변수

        // 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용
        java.util.Scanner s = new java.util.Scanner(System.in);

        do {
            count++;
            System.out.print("1과 100사이의 값을 입력하세요 :");
            input = s.nextInt(); // 입력받은 값을 변수 input에 저장한다.

            // answer과 input 비교
            if(input == answer) break;
            if(input < answer){
                System.out.println("더 큰 수를 입력하세요.");
            }else {
                System.out.println("더 작은 수를 입력하세요.");
            }
        } while(true);

        System.out.println("맞췄습니다.\n시도횟수는 "+count+"입니다.");
    }
}
