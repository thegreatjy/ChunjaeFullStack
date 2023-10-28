package week2;

class Car {
    // 필드 선언
    String company = "현대";
    String model = "그랜저";
    boolean start ;
    String color = "검정";
    int speed;

    public Car(){}

    public Car(String company, String model, String color) {
        this.company = company;
        this.model = model;
        this.color = color;
    }

    private TireClass tire1 = new TireClass();
    private TireClass tire2 = new TireClass(){
        @Override
        public void roll() {
            System.out.println("익명 자식 Tire 객체 2가 굴러갑니다.");
        }
    };

    public void run(){
        tire1.roll();
        tire2.roll();
    }

    public void run2(){
        TireClass tire = new TireClass(){
            @Override
            public void roll() {
                System.out.println("익명 자자식 Ture 객체 3가 굴러갑니다.");
            }
        };
        tire.roll();
    }

    public void run3(TireClass tire){
        tire.roll();
    }
}

public class CarExample{
    public static void main(String[] args) {
        Car c1 = new Car("현대", "그랜저", "검정");
        Car c2 = new Car("현대2", "그랜저2", "검정2");
        Car c3 = new Car("현대3", "그랜저3", "검정3");

        System.out.println("모델명 : " + c1.model);
        System.out.println("회사 : " + c1.company);
        System.out.println("색 : " + c1.color);

        System.out.println("모델명 : " + c2.model);
        System.out.println("회사 : " + c2.company);
        System.out.println("색 : " + c2.color);

        System.out.println("모델명 : " + c3.model);
        System.out.println("회사 : " + c3.company);
        System.out.println("색 : " + c3.color);

        Car car = new Car();
        car.run();
        car.run2();
        car.run3(new TireClass(){
            @Override
            public void roll() {
                System.out.println("익명 자식 Tire 객체 3이 굴러갑니다.");
            }
        });
    }
}