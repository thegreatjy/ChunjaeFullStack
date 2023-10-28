package week3;

public class ProductExample {
    public static void main(String[] args) {
        Product<Tv, String> product1 = new Product<Tv, String>();

        product1.setKind(new Tv());
        product1.setModel(new String("스마트 티비"));

        Tv tv = product1.getKind();
        String model = product1.getModel();


        Product<Car, String> product2 = new Product<>();

        product2.setModel("SUV 자동차");
        product2.setKind(new Car());

        product2.getKind();
        String model2 = product2.getModel();
    }
}
