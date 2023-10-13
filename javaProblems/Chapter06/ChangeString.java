package javaProblems.Chapter06;

public class ChangeString {
    public static void change(String a) {
        a = "ABC456";
    }
    public static void main(String[] args){
        String str = "ABC123";
        System.out.println(str);
        change(str);
        System.out.println("After change:"+str);
    }

}
