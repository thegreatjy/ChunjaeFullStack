package week2;

import java.io.EOFException;
import java.io.IOException;
import java.io.NotActiveException;
import java.util.EmptyStackException;

public class Computer extends Calculator{
    @Override
    public double areaCircle(double r) throws NullPointerException, EmptyStackException{
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }

}
