package javaProblems.Chapter04;

public class NumberOfCasesForDice {
    //두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프
    //로그램을 작성하시오.
    public static void main(String[] args) {
        for(int dice1=1; dice1<=6; dice1++){
            for(int dice2=1; dice2<=6; dice2++){
                System.out.println("주사위 1 : "+dice1+" 주사위 2 : "+dice2);
            }
        }
    }
}
