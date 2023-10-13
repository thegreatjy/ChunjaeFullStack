package javaProblems.Chapter4;

// ch4 # 5
// 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이
// 100이상이 되는지 구하시오.
public class ChangeForIntoWhile {
    public static void main(String[] args) {
        // original
        for(int i=0; i<=10; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }

        System.out.println("=====================================");

        //change to while()
        int i = 0;
        while(i<10) {
            int j = 0;
            while (j <= i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
