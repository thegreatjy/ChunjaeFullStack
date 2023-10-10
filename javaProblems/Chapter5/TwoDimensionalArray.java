package javaProblems.Chapter5;

// Ch 5 # 11
public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] score = {
                {100, 100, 100},
                {20, 20, 20},
                {30, 30, 30},
                {40, 40, 40},
                {50, 50, 50}
        };

        int[][] result = new int[score.length+1][score[0].length+1];
        for(int i=0; i < score.length; i++) {
            for(int j=0; j < score[i].length; j++) {
                result[i][j] = score[i][j];
                result[score.length][j] += result[i][j]; // 마지막 열에 해당 열의 누적합을 대입
                result[i][score[0].length] += result[i][j];    // 마지막 행에 해당 행의 누적합을 대입
                result[score.length][score[0].length] += result[i][j];
            }
        }

        for(int i=0; i < result.length;i++) {
            for(int j=0; j < result[i].length;j++) {
                System.out.printf("%4d", result[i][j]);
            }
            System.out.println();
        }
    }
}
