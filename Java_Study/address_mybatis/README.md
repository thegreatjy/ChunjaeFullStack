# Java + MariaDB + MyBatis Project
해당 프로젝트를 하며 MariaDB와 MyBatis 사용 연습을 하였습니다.
소스코드는 차태진님의 [MyBatis 개념과 세팅및 사용법](https://youtu.be/eMuFWW6-8i0?si=dv7ZTQyppn0krpDN) 유튜브 영상을 참고했습니다.
이 영상과 MyBatis 공식 Docs를 참고하여 공부한 내용을 정리했습니다.

## Development Environment
- IntelliJ
- Java 11
- MariaDB 3.2.0
- MyBatis 3.5.11

## Description
| 파일 | 설명 |
| --- | --- |
| Addr 클래스 | 주소록(이름, 주소, 전화번호) 정보를 가진 클래스  |
| AddrApp 클래스 | 메인 메서드 존재. 사용자로부터 CRUD 명령을 받아 DBUtil 객체에 주소록 CRUD 기능 요청 |
| AddrMapper 인터페이스 | Mapper.xml에 있는 SQL문을 호출하는 인터페이스 |
| AddrMapper.xml | 인터페이스와  SQL문을 연결한다.  |
| DBUtil 클래스 | 데이터베이스와 직접 소통하는 객체 |
| myconfig.xml | DB 연결 설정 |
| WebView 클래스 | 콘솔에 Addr 클래스를 출력한다. |

## Prerequisite
- MariaDB 3306 포트로 연결
  - 포트 수정 시, myconfig.xml과 DBUtil.java 파일 수정
- addr_prg 데이터베이스, t_address 테이블 생성
```sql
CREATE TABLE
`t_address` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(20) NOT NULL,
`address` varchar(10) NOT NULL,
`phone` varchar(13) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 9 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci
```

## How to Run in IntelliJ
1. IntelliJ 프로젝트 [lib 폴더](lib)에 MariaDB, MyBatis 라이브러리 추가 
2. File > Project Structure > Project Settings > Modules > Dependencies > + > 1. Add Jars 에 [mariadb.jar](lib) 파일을 추가한다.
3. AddrApp 실행

## What I Learned
### Mapper 인터페이스: [AddrMapper](src/addr/AddrMapper.java)

Mapping 파일(mapper xml 파일, 여기에서는 AddrMapper.xml)에 기재된 SQL을 호출하기 위한 인터페이스.

Mapping 파일에 있는 SQL문을 인터페이스로 호출한다.

### Mapper xml 파일: [AddrMapper.xml](src/addr/AddrMapper.xml)

[MyBatis 공식 문서 참고](https://mybatis.org/mybatis-3/sqlmap-xml.html)

파일 상단에

```sql
<mapper namespace = "패키지명.mapper인터페이스명">
```

으로 mapper 인터페이스와 연결해준다.

이 프로젝트에서는

```sql
<mapper namespace = "addr.AddrMapper">
```

이다.

대표적으로 insert, update, delete, select문을 사용할 수 있다.

insert문 예시를 통해 설명한다.


- insert문

```sql
<insert id="insertAddress" parameterType="addr.Addr">
	INSERT INTO t_address
	SET `name` = #{name},
	address = #{address},
	phone = #{phone}
</insert >
```

- id
    - 인터페이스에 선언된 메서드명
- parameterType
    - 파라미터의 패키지 경로를 포함한 전체 클래스명이나 별칭
    - 주소록 클래스 객체가 매개변수로 들어오게 된다. 따라서 패키지.클래스의 전체 클래스명인 `addr.Addr`.
- resultType
    - 리턴되는 기대타입의 패키지 경로를 포함한 전체 클래스명이나 별칭

### SqlSessionFactory: [DBUtil](src/addr/DBUtil.java)

MariaDB와 MyBatis를 연결하는 객체이다.

접속(session, DB와 java 프로그램을 연결)을 관리해주는 객체

```sql
InputStream inputStream = Resources.getResourceAsStream("addr/myconfig.xml");
```

`addr/myconfig.xml`로부터 inputStream을 설정한다.

```sql
// 접속(session, DB와 java 프로그램을 연결)을 관리해주는 객체
sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
```

sqlSessionFactory 객체를 생성한다.

```sql
public void insertAddress(String name, String address, String phone) {
	SqlSession session = sqlSessionFactory.openSession();
	AddrMapper mapper = session.getMapper(AddrMapper.class);
	Addr addr = new Addr(name, address, phone);
	mapper.insertAddress(addr);
	// 데이터 변경이 있을 때, session.commit()을 해주어야 한다. select(검색)할 때에는 안 해줘도 됨.
	session.commit(); // update, delete, insert
}
```

session을 열어준다.

AddrMapper 인터페이스 구현 객체를 생성한다.

이 구현 객체의 insertAddress()메서드를 통해 Addr 객체(주소록 객체)를 전달한다.

그러면 mapper xml파일(AddrMapper.xml)에 정의된 구문 중 id="insertAddress"인 구문이 실행된다. 구문에 연결된 SQL문이 실행된다.

쿼리 동작이 끝나면 정상적으로 처리된 경우 commit()을 통해 트랜잭션을 끝낸다.

---

### References

[https://mybatis.org/mybatis-3/ko/index.html](https://mybatis.org/mybatis-3/ko/index.html)

[https://youtu.be/eMuFWW6-8i0?si=hiYQ4tEsok1Dl65v](https://youtu.be/eMuFWW6-8i0?si=hiYQ4tEsok1Dl65v)

[https://kookyungmin.github.io/server/2018/08/13/spring_06/](https://kookyungmin.github.io/server/2018/08/13/spring_06/)
