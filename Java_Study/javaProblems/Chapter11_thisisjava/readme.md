# <이것이 자바다> Chapter 11 예외 처리

## 1. 예외에 대한 설명 중 틀린 것은 무엇입니까?

➊ 예외는 사용자의 잘못된 조작, 개발자의 잘못된 코딩으로 인한 프로그램 오류를 말한다.

➋ RuntimeException의 하위 예외는 컴파일러가 예외 처리 코드를 체크하지 않는다.

➌ 예외는 try-catch 블록을 사용해서 처리된다.

➍ 자바 표준 예외만 프로그램에서 처리할 수 있다.

A.

1. 사용자 정의 예외를 정의하고 처리할 수 있다.

## 2. try-catch-finally 블록에 대한 설명 중 틀린 것은 무엇입니까?

➊try {}블록에는예외가발생할수있는코드를작성한다.

➋catch {}블록은try {}블록에서발생한예외를처리하는블록이다.

➌ try { } 블록에서 return 문을 사용하면 finally { } 블록은 실행되지 않는다.

➍catch {}블록은예외의종류별로여러개를작성할수있다.

A.

1. return 문이 나오기 전에 예외가 발생하면 finally 구문이 실행된다.

## 3. throws에 대한 설명으로 틀린 것은 무엇입니까? (오답)

➊ 생성자나 메소드의 선언 끝 부분에 사용되어 내부에서 발생된 예외를 떠넘긴다.

➋ throws 뒤에는 떠넘겨야 할 예외를 쉼표(,)로 구분해서 기술한다.

➌ 모든 예외를 떠넘기기 위해 간단하게 throws Exception으로 작성할 수 있다.

➍ 새로운 예외를 발생시키기 위해 사용된다.

A.

1. 메서드 선언문 마지막에 throws 예외클래스 를 통해 메서드 내에서 예외가 발생했을 때, 해당 메서드를 호출한 메서드에서 예외 처리를 떠넘긴다. throw 예외 객체 생성을 통해 사용자 지정 예외를 정의한다. 

## 4. throw에 대한 설명으로 틀린 것은 무엇입니까?

➊ 예외를 최초로 발생시키는 코드이다.

➋ 예외를 호출한 곳으로 떠넘기기 위해 메소드 선언부에 작성된다.

➌ throw로 발생된 예외는 일반적으로 생성자나 메소드 선언부에 throws로 떠넘겨진다.

➍ throw 키워드 뒤에는 예외 객체 생성 코드가 온다.

A.

1. throws는 예외를 떠넘기기 위해 메서드 선언부 마지막에 작성된다. throw는 예외객체를 반환한다. 

## 5. 메소드가 다음과 같이 선언되어 있습니다. 잘못된 예외 처리를 선택하세요.

```java
public void method1() throws NumberFormatException, ClassNotFoundException { ... }
```

➊ try { method1(); } catch (Exception e) { }

➋ void method2 ( ) throws Exception { method1 ( ); }

➌ try { method1(); } catch (Exception e ) { } catch (ClassNotFoundException e ) { }

➍ try { method1(); } catch (ClassNotFoundException e ) { } catch (NumberFormatException e ) { }

A.

1. Exception은 ClassNotFoundException의 상위 클래스이다. 따라서 Exception 객체를 먼저 catch문으로 사용될 경우, ClassNotFoundException catch문은 실행되지 않는다. 따라서 순서를 바꿔서 작성해준다. 

## 6. 다음 코드가 실행되었을 때 출력 결과를 작성해보세요.

```java
String[] strArray = { "10", "2a" }; 
int value = 0;

for(int i=0; i<=2; i++) {
	try {
		value = Integer.parseInt(strArray[i]);
	} catch(ArrayIndexOutOfBoundsException e) { 
			System.out.println("인덱스를 초과했음");
	} catch(NumberFormatException e) { 
			System.out.println("숫자로 변환할 수 없음");
	} finally { 
			System.out.println(value);
	} 
}
```

A.

10

숫자로 변환할 수 없음

10

인덱스를 초과했음

10

## 7. login ( ) 메소드에서 존재하지 않는 ID를 입력하면 NotExistIDException을 발생시키고, 잘못된 패스워드를 입력하면 WrongPasswordException을 발생시키려고 합니다. 다음 LoginExample 의 실행 결과를 보고 빈칸을 채워보세요.

[Solution code](./LoginExample.java)

## 8. FileWriter는 파일을 열고 데이터를 저장하는 클래스입니다. 예외 발생 여부와 상관 없이 마지막 에는 close ( ) 메소드를 실행해서 파일을 닫아주려고 합니다. 왼쪽 코드는 try-catch-finally를 이 용해서 작성한 코드로, 리소스 자동 닫기를 이용하도록 수정하고 싶습니다. 수정한 코드를 오른쪽에 작성해보세요. (오답)

[Solution code](./LoginExample.java)