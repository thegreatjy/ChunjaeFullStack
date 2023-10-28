package week3.ch15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("이름1", 85);
        map.put("이름2", 80);
        map.put("이름3", 95);
        map.put("이름4", 94);
        map.put("이름5", 90);
        map.put("이름6", 75);

        System.out.println("총 entry 수 :"+map.size());

        String key = "이름3";
        int value = map.get(key);
        System.out.println(key+": "+value);

        Set<String> ketSet = map.keySet();
        Iterator<String> it = ketSet.iterator();

        while (it.hasNext()){
            String k = it.next();
            Integer v = map.get(k);
            System.out.println(k +": "+v);
        }
        System.out.println();


        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for(Map.Entry<String, Integer> ent : entrySet){

        }
    }
}
