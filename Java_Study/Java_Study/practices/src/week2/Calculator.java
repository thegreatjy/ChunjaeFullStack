package week2;

import java.util.EmptyStackException;

public class Calculator  {
    static double pi = 2.14159;

    void powerOn(){
        System.out.println("전원을 켭니다.");
    }
    void powerOff(){
        System.out.println("전원을 끕니다.");
    }

    int plus(int x, int y){
        return x+y;
    }

    int subtract(int x, int y){
        return x-y;
    }

    int multiply(int x, int y){
        return x*y;
    }

    double divide(int x, int y){
        if(y==0)    return 0;
        return (double)x/y;
    }

    public double areaCircle(double r) throws EmptyStackException {
        System.out.println("calculator 객체의 areaCircle() 실행");
        return 3.14159 * r * r;
    }
}
