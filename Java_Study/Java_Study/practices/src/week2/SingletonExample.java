package week2;

class Singleton{
    private static Singleton singleton = new Singleton();

    private Singleton(){};

    public static Singleton getInstance(){
        return singleton;
    }
}

public class SingletonExample {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if(obj1.equals(obj2)){
            System.out.printf("같은 singleton 객체입니다.");
        }else{
            System.out.printf("다른 singleton 객체입니다.");
        }
    }
}
