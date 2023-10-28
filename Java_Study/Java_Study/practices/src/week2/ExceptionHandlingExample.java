package week2;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try{
            Class.forName("java.lang.String");
            System.out.println("java.lang.String 클래스가 존재합니다.");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println();

        try{
            Class.forName("java.lang.String2");
            System.out.println("java.lang.String2 클래스가 존재합니다.");
        }catch(ClassNotFoundException e){
            System.out.println("java.lang.String2 클래스가 존재하지 않습니다.");
            e.printStackTrace();
        }
    }
}
