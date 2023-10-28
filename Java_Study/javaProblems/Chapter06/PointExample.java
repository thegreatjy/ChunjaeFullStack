package javaProblems.Chapter06;

public class PointExample {
    // 6-6
    // 두 점 (x,y)와 (x1,y1)간의 거리를 구한다.
    static double getDistance(int x, int y, int x1, int y1) {
        return Math.sqrt(Math.pow(x-x1, 2) + Math.pow(y-y1, 2));
    }

    public static void main(String[] args) {
        System.out.println(getDistance(1,1,2,2));

        MyPoint p = new MyPoint(1, 1);
        System.out.println(p.getDistance((byte)2, 2));
    }
}

class MyPoint {
    int x;
    int y;

    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // 6-7
    double getDistance(int x, int y){
        System.out.println("int");
        return Math.sqrt(Math.pow(this.x-x, 2) + Math.pow(this.y-y, 2));
    }

    double getDistance(long x, int y){
        System.out.println("long");
        return Math.sqrt(Math.pow(this.x-x, 2) + Math.pow(this.y-y, 2));
    }

    double getDistance(byte x, byte y){
        System.out.println("byte");
        return Math.sqrt(Math.pow(this.x-x, 2) + Math.pow(this.y-y, 2));
    }
}
