package week2;

public class Korean {
    String nation = "대한민국";
    String name;
    String ssn;

    public Korean(){

    }
    public Korean(String n, String s){
        name = n;
        ssn = s;
    }



    public static void main(String[] args) {
        Korean k = new Korean("박자바", "123456-789999");
        System.out.println("k1.nation : "+k.nation);
        System.out.println("k1.name : "+k.name);
        System.out.println("k1.ssn : "+k.ssn);
    }
}
