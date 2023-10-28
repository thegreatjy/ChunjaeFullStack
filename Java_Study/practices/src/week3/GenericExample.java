package week3;

public class GenericExample {
    public static void main(String[] args) {
        HomeAgency ha = new HomeAgency();
        Home home = ha.rent();
        home.turnOnLight();

        CarAgency ca = new CarAgency();
        Car car = ca.rent();
        car.run();
    }
}
