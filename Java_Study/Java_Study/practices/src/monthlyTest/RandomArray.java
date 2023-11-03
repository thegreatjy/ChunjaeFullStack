package monthlyTest;

import java.util.*;

public class RandomArray {
    public static void main(String[] args) {
        // Integer 배열 생성
        List<Integer> randomIntegers = new ArrayList<>();
        // 1-100 난수 5개 생성 & 배열에 삽입
        for(int i=0; i<5; i++){
            randomIntegers.add((int)(Math.random()*100));
        }
        // 배열 정렬
        randomIntegers.sort((a, b) -> (a - b));
        // 배열 출력
        System.out.println("==============");
        for(int r:randomIntegers){
            System.out.print(r + " ");
        }
        System.out.println("\n==============");

        System.out.println("최댓값: " + randomIntegers.get(randomIntegers.size() - 1));
        System.out.println("최솟값: " + randomIntegers.get(0));
        System.out.println("중간값: " + randomIntegers.get(randomIntegers.size()/2));
    }
}