package week2;

public class MultiInterfaceImplExample {
    public static void main(String[] args) {
        RemoteControl rc = new SmartTelevision();
        rc.turnOn();
        rc.turnOff();
        // rc.search(); 는 불가능

        Searchable sc = new SmartTelevision();
        sc.search("http://google.com");
    }


}
