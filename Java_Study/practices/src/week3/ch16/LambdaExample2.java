package week3.ch16;

public class LambdaExample2 {
    public static void main(String[] args) {
        Person2 person = new Person2();

        person.action( ((a,b) -> {
            System.out.println(a+"이 "+b+" 일을 합니다.");
        }));

        person.action2( content -> {
            System.out.println("작업내용 : " + content);
        });
    }
}
