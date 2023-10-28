package week3.ch15;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        System.out.println(new String("Java").hashCode());
        System.out.println(System.identityHashCode(new String("Java")));
        System.out.println(new String("Java").hashCode());
        System.out.println("Java".hashCode());
        System.out.println(System.identityHashCode(new String("Java")));

        System.out.println(" ".hashCode());
        System.out.println("a".hashCode());
        System.out.println("ab".hashCode());

        set.add("Java");

    }
}
