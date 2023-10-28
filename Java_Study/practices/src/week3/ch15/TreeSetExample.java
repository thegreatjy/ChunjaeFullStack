package week3.ch15;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<>();

        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(95);
        scores.add(80);
        scores.add(11);

        for(Integer s: scores){
            System.out.print(s+" ");
        }
        System.out.println("\n");

        System.out.println("가장 낮은 점수 :" + scores.first());
        System.out.println("가장 높은 점수 :" + scores.last());
        System.out.println("95 미만 점수 :" + scores.lower(95));
        System.out.println("95 초과 점수 :" + scores.higher(95));
        System.out.println("95 이하 점수 :" + scores.floor(95));
        System.out.println("85 이상 점수 :" + scores.ceiling(85));

        // 80 <= score
        NavigableSet<Integer> rangeSet = scores.tailSet(80, true);
        for(int s:rangeSet){
            System.out.println(s+" ");
        }
        System.out.println("\n");

        // 80 <= score < 90
        rangeSet = scores.subSet(80, true, 90, false);
        for(int s:rangeSet){
            System.out.println(s+" ");
        }
    }
}
