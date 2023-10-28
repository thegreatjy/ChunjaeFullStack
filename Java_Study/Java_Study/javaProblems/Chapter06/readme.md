# 6장 객체지향 프로그래밍 1

### 6-1. 다음과 같은 멤버변수를 갖는 SutdaCard 클래스를 정의하시오.

| 타입 | 변수명 | 설명 |
| --- | --- | --- |
| int | num | 카드의 숫자. 1-10사이의 정수 |
| boolean | isKwang | 광이면 true, 아니면 false |

```java
Class SutdaCard{
	int num;
	boolean isKwang;

	SutdaCard(){};
	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
}
```

### 6-2. 문제 6-1에서 정의한 SutdaCard클래스에 두 개의 생성자와 info()를 추가해서 실행 결과와 같은 결과를 얻도록 하시오.

```java
class Exercise6_2 {
	public static void main(String args[]) {
		SutdaCard card1 = new SutdaCard(3, false); 
		SutdaCard card2 = new SutdaCard();
		System.out.println(card1.info()); 
		System.out.println(card2.info());
		}
}

class SutdaCard {
	int num = 1;
	boolean isKwang = true;

	SutdaCard(){};
	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	
	void info(){
		if(isKwang)
			System.out.println(num + "K");
		else
			System.out.println(num);
	}
}
```

### 6-3. 다음과 같은 멤버변수를 갖는 Student클래스를 정의하시오.

| 타입 | 변수명 | 설명 |
| --- | --- | --- |
| String | name | 학생이름 |
| int | ban | 반 |
| int | no | 번호 |
| int | kor | 국어점수 |
| int | eng | 영어점수 |
| int | math | 수학점수 |

```java
Class Student{
	String name;
	int ban, no, kor, eng, math;
}
```

### 6-4. 문제6-3에서 정의한 Student클래스에 다음과 같이 정의된 두 개의 메서드 getTotal()과 getAverage()를 추가하시오.

1. 메서드명 : getTotal
기 능 : 국어(kor), 영어(eng), 수학(math)의 점수를 모두 더해서 반환한다.
반환타입 : int
매개변수 : 없음

2. 메서드명 : getAverage
기 능 : 총점(국어점수+영어점수+수학점수)을 과목수로 나눈 평균을 구한다. 소수점 둘째자리에서 반올림할 것.

반환타입 : float 
매개변수 : 없음

[solution code](./StudentExample.java)

### 6-5 Student클래스에 생성자와 info()를 추가하시오.

[solution code](./StudentExample.java)

### 6-8. 다음의 코드에 정의된 변수들을 종류별로 구분해서 적으시오. (오답)

- 클래스 변수(static 변수) : width, height
- 인스턴스 변수 : kind, num
- 지역 변수 : k, n, **args, card**

![Untitled](https://github.com/thegreatjy/JavaStudy/assets/74610908/c1d86e7c-b4bc-4d59-a2c2-c779725a427b)

| 변수의 종류 | 선언 위치 | 생성 시기 |
| --- | --- | --- |
| 클래스 변수(static) | 클래스 영역  | 클래스가 메모리에 로딩될 때 |
| 인스턴스 변수 | 클래스 영역 | 인스턴스가 생성되었을 때 |
| 지역 변수 | 클래스 영역 외 | 변수 선언문이 수행되었을 때 |

### 6-9. 다음은 컴퓨터 게임의 병사(marine)를 클래스로 정의한 것이다. 이 클래스의 멤버
중에 static을 붙여야 하는 것은 어떤 것들이고 그 이유는 무엇인가?
(단, 모든 병사의 공격력과 방어력은 같아야 한다.)

A.

weapon, armor는 병사 클래스가 모두 동일하게 갖고 있는 값이므로 static 변수로 정의한다.

**두 변수를 사용하는 메서드인 weaponUp(), armorUp() 메서드 또한 static 으로 정의한다.** 

### 6-10. 다음 중 생성자에 대한 설명으로 옳지 않은 것은? (모두 고르시오) (오답)

a. 모든 생성자의 이름은 클래스의 이름과 동일해야한다.
b. 생성자는 객체를 생성하기 위한 것이다.
**c. 클래스에는 생성자가 반드시 하나 이상 있어야 한다.**

d. 생성자가 없는 클래스는 컴파일러가 기본 생성자를 추가한다.
e. 생성자는 오버로딩 할 수 없다.

A.

b. 생성자는 인스턴스 변수를 초기화한다. 객체는 new 연산자를 통해 생성되어 Heap 영역에 저장된다.

e. 파라미터 개수와 자료형이 다른 생성자를 여러 개 생성할 수 있다.

### 6-11.  다음 중 this에 대한 설명으로 맞지 않은 것은? (모두 고르시오)

a. 객체 자신을 가리키는 참조변수이다.
b. 클래스 내에서라면 어디서든 사용할 수 있다.
c. 지역변수와 인스턴스변수를 구별할 때 사용한다.

d. 클래스 메서드 내에서는 사용할 수 없다.

A.

b. static 메서드 안에서는 사용이 불가능하다.

### 6-12. 다음 중 오버로딩이 성립하기 위한 조건이 아닌 것은? (모두 고르시오)

a. 메서드의 이름이 같아야 한다.
b. 매개변수의 개수나 타입이 달라야 한다.
c. 리턴타입이 달라야 한다.

d. 매개변수의 이름이 달라야 한다.

A.

c,d. 리턴타입과 매개변수 이름은 관계없다.

### 6-13. 다음 중 아래의 add메서드를 올바르게 오버로딩 한 것은? (모두 고르시오) (오답)

`long add(int a, int b) { return a+b;}`

a. long add(int x, int y) { return x+y;}
b. long add(long a, long b) { return a+b;}
c. int add(byte a, byte b) { return a+b;}
d. int add(long a, int b) { return (int)(a+b);}

A.

b, c, d

### 6-14. 다음 중 초기화에 대한 설명으로 옳지 않은 것은? (모두 고르시오) (오답)

a.멤버변수는 자동 초기화되므로 초기화하지 않고도 값을 참조할 수 있다.
b.지역변수는 사용하기 전에 반드시 초기화해야 한다.
c.초기화 블럭보다 생성자가 먼저 수행된다.

d.명시적 초기화를 제일 우선적으로 고려해야 한다.
e.클래스변수보다 인스턴스변수가 먼저 초기화된다.

A.

**c. 초기화 블럭이 먼저 수행된다. 클래스 변수(static)은 클래스가 처음 메모리에 로딩될 때, 자동 초기화된다. 클래스 변수는 인스턴스 변수보다 먼저 초기화된다. 생성자는 초기화 블럭이 수행된 다음에 수행된다.**

e. 클래스 변수 (static)는 프로그램 실행 시, static 영역에 저장된다. 인스턴스 변수는 인스턴스가 생성된 후, 생성된다.

### 초기화

- 멤버 변수는 자동 초기화된다.
- 지역 변수는 사용하기 전에 반드시 초기화를 해야한다. 그렇지 않으면 쓰레기 값이 들어간다.
- static 클래스 변수 > 인스턴스 변수 > 초기화 블럭 > 생성자 순으로 초기화된다.

### 6-15. 다음 중 인스턴스 변수의 초기화 순서가 올바른 것은? (오답)

a. 기본값-명시적초기화-초기화블럭-생성자
b. 기본값-명시적초기화-생성자-초기화블럭
c. 기본값-초기화블럭-명시적초기화-생성자

d. 기본값-초기화블럭-생성자-명시적초기화

A.

a

### 변수의 초기화 순서

- 클래스 변수 (static) : 클래스가 처음 로딩될 때, 단 한번 초기화 된다.
    - 기본값 → 명시적 초기화(변수 선언과 동시에 값 대입) → 클래스 초기화 블럭
- 인스턴스 변수 : 클래스의 인스턴스가 생성될 때마다 인스턴스별로 초기화가 이루어진다.
    - 기본값 → 명시적 초기화 → 인스턴스 초기화 블럭 > 생성자

### 6-16. 다음 중 지역변수에 대한 설명으로 옳지 않은 것은? (모두 고르시오) (오답)

a. 자동 초기화되므로 별도의 초기화가 필요없다.
b. 지역변수가 선언된 메서드가 종료되면 지역변수도 함께 소멸된다.
c. 매서드의 매개변수로 선언된 변수도 지역변수이다.

d. 클래스변수나 인스턴스변수보다 메모리 부담이 적다.
e. 힙(heap)영역에 생성되며 가비지 컬렉터에 의해 소멸된다.

A.

a. 지역변수는 초기화하지 않으면 garbage값이 들어가게 된다.

e. stack 영역에 생성되며 지역변수가 생성된 메서드 실행이 끝나면 소멸된다.

### 6-17. 호출스택이 다음과 같은 상황일 때 옳지 않은 설명은? (모두 고르시오)

| println (pc) |
| --- |
| method1 |
| method2 |
| main |

a. 제일 먼저 호출스택에 저장된 것은 main메서드이다.
b. println메서드를 제외한 나머지 메서드들은 모두 종료된 상태이다.
c. method2메서드를 호출한 것은 main메서드이다.
d. println메서드가 종료되면 method1메서드가 수행을 재개한다.
e. main-method2-method1-println의 순서로 호출되었다.
f. 현재 실행중인 메서드는 println 뿐이다.

A.

b. 나머지 메서드 실행 도중에 println이 호출되었다. println 실행이 끝나고 다시 method1, method2, main으로 돌아가서 실행한다.

f 설명 : 현재 실행 중인 메서드는 println이고 호출 스택 안의 나머지 메서드들은 대기 상태이다.

### 6-18. 다음의 코드를 컴파일하면 에러가 발생한다. 컴파일 에러가 발생하는 라인과 그 이유를 설명하시오.

```java
class MemberCall { 
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
	static int cv2 = iv; //라인 A
	
	static void staticMethod1(){
		System.out.println(cv);
		System.out.println(iv); //라인 B
	}
	
	void instanceMethod1(){
		System.out.println(cv);
		System.out.println(iv); //라인 C
	}
	
	static void staticMethod2() { 
		staticMethod1();
		instanceMethod1(); //라인 D
	}
	
	void instanceMethod2() { 
		staticMethod1(); //라인 E
		instanceMethod1();
	}
}
```

- 라인 A
    - static 변수는 MemberCall 클래스가 로딩될 때, 메모리에 로딩된다. 하지만 인스턴스 변수인 iv는 클래스가 생성된 후 메모리에 로딩되므로 cv2 생성 이후에 생성된다. 따라서 cv2에 iv값을 대입할 때 오류가 발생한다.
- 라인 B
    - staticMethod1은 static 메서드로 static 변수만 사용 가능하다. 객체 인스턴스 생성 없이 사용가능한 메서드로 iv에 접근이 불가능하다.
- 라인 D
    - static method는 객체를 생성하지 않고도 사용 가능하다. 하지만 instanceMethod1은 인스턴스 메서드로 객체 생성 이후에만 사용 가능하다.

### 6-19. 다음 코드의 실행 결과를 예측하여 적으시오. (오답)

```java
class Exercise6_19{ 
	public static void change(String str) {
		str += "456";
	}
	public static void main(String[] args){
		String str = "ABC123"; 
		System.out.println(str);
		change(str);
		System.out.println("After change:"+str);
	}
}
```

ABC123

ABC123