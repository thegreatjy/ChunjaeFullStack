package javaProblems.Chapter13_thisisjava;

public class Util {
    public static <K, V> V getValue(Pair<K, V> p, K key){
        // p.key == key 일 경우, key 리턴
        // otherwise null
        if(p.getKey() == key)
            return p.getValue();
        else
            return null;
    }
}
