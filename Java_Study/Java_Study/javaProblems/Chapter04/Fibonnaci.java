package javaProblems.Chapter04;

// ch4 # 11
public class Fibonnaci {
    public static void main(String[] args) {
        int num1 = 1, num2 = 1, num3 = 0;
        System.out.print(num1+", "+num2);

        int output = 0;
        for(int i=0; i<8; i++){
            num3 = num1 + num2;
            output = num3;
            num1 = num2;
            num2 = num3;

            System.out.print(", " + output);
        }
    }
}
