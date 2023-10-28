# <이것이 자바다> Ch 16 람다식

## 1. 람다식에 대한 설명으로 틀린 것은 무엇입니까?

➊ 람다식은 함수형 인터페이스의 익명 구현 객체를 생성한다. 

➋ 매개변수가 없을 경우 ( ) -> {...} 형태로 작성한다.

➌ (x,y ) -> { return x+y; }는 (x,y ) -> x+y로 바꿀 수 있다.

➍ @FunctionalInterface가 기술된 인터페이스만 람다식으로 표현이 가능하다.

A.
4. 애너테이션을 작성하여 컴파일러가 추상 메서드가 한 개인지 검사할 수 있게 한다. 작성하지 않아도 정상적으로 실행된다.


## 3. 다음 중 잘못 작성된 람다식은 무엇입니까?

➊ a -> a+3 

➋ a,b -> a*b

➌ x -> System.out.println(x/5 ) 

➍ (x,y ) -> Math.max (x, y )

A.
2. (a,b) -> a*b 로 수정해야 한다. 매개변수가 2개 이상인 경우에는 괄호를 붙여야 한다.


## 4. 다음 코드의 실행 결과를 보고 빈 곳에 들어갈 람다식을 작성해보세요.
```java
public class Example {
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    for(int i=0; i<3; i++) {
                        System.out.println("작업 스레드가 실행됩니다.");
                    }
                }
        );
        thread.start(); 
    }
}
```

## 5. 다음 코드의 실행 결과를 보고 밑줄 친 곳에 들어갈 람다식을 작성해보세요.
```java
public class Button {
    //정적 멤버 인터페이스(함수형 인터페이스)
    @FunctionalInterface
    public static interface ClickListener{
        void onClick();
    }
    
    private ClickListener clickListener;
    
    public void setClickListener(ClickListener clickListener) { 
        this.clickListener = clickListener;
    }
    public void click() { 
        this.clickListener.onClick();
    } 
}

```
```java
public class Example {
    public static void main(String[] args) {
        Button btnOk = new Button();
        btnOk.setClickListener(()->{
            System.out.println("OK 버튼을 클릭했습니다.");
        }); 
        btnOk.click();
        
        Button btnCancel = new Button();
        btnCancel.setClickListener(()->{
            System.out.println("Cancel 버튼을 클릭했습니다.");
        }); 
        btnCancel.click();
    } 
}
```
```text
// 실행 결과
Ok 버튼을 클릭했습니다. 
Cancel 버튼을 클릭했습니다.
```

## 6. 다음 코드를 보고, Function 함수형 인터페이스를 작성해보세요.
```java
public class Example {
    public static double calc(Function fun) {
        double x = 10;
        double y = 4;
        return fun.apply(x, y);
    }
    public static void main(String[] args) { 
        double result = calc( (x, y) -> (x / y) ); 
        System.out.println("result: " + result);
    } 
}
```
```text
// 실행 결과 
result: 2.5
```
--- solution ---
```java
@FunctionalInterface
public interface Function {
    public double apply(double x, double y);
}
```