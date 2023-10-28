package week3;

public class GenericExample_3 {
    // 제네릭 메서드
    public static<T> Box<T> boxing(T t){
        Box<T> box = new Box<>();
        box.setT(t);
        return box;
    }

    public static void main(String[] args) {
        // 제네릭 메서드 호출
        Box<Integer> box1 = boxing(100);
        int intValue = box1.getT();
        System.out.println(intValue);

        Box<String> box2 = boxing("Hello");
        String str = box2.getT();
        System.out.println(str);
    }
}
