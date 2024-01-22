import java.util.Date;

public class UnderstandDI {
    // 강한 결합 - 직접 생성
    public static void memberUse1(){
        Member m1 = new Member();
    }
    // 약한 결합 - 생성된 것을 주입받는다.(의존 주입. Dependency Injection)
    public static void memberUse2(Member m){
        Member m2 = m;
    }



    public static void main(String[] args) {
        // 강한 결합 - 날짜 객체 직접 생성
        Date date = new Date();
        System.out.println(date);
    }

    // 약한 결합 - 날짜 객체 인스턴스를 주입 받음
    public static void getDate(Date d){
        Date date = d;
        System.out.println(date);
    }
}

class Member{
    String name;
    String nickname;
    public Member(){}
}