package javaProblems.Chapter13_thisisjava;

public class Container2 <K, V> {
    K key;
    V value;

    K getKey(){
        return key;
    }
    V getValue(){
        return value;
    }

    void set(K k, V v){
        this.key = k;
        this.value = v;
    }
}
