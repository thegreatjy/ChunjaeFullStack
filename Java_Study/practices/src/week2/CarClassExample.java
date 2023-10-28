package week2;

public class CarClassExample {
    public static void main(String[] args) {
        CarClass car = new CarClass();

        car.run();

        car.tire1 = new KumhoTire();
        car.run();
    }
}
