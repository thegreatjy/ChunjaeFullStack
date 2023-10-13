package javaProblems.Chapter06;

import java.util.Arrays;

public class shuffleArray {
    static int[] shuffle(int[] original){
        int tmp = 0;
        for(int i=0; i<original.length; i++){
            int rand = (int)(Math.random()*original.length);
            tmp = original[i];
            original[i] = original[rand];
            original[rand] = tmp;
        }
        return original;
    }

    public static void main(String[] args) {
        int[] original = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(original));

        int[] result = shuffle(original);
        System.out.println(Arrays.toString(result));
    }
}
