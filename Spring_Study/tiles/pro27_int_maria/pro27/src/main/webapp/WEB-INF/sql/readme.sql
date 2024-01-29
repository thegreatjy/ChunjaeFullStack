DROP TABLE t_member;
-- 회원 테이블 생성
CREATE TABLE t_member(
                         id VARCHAR(20) primary key,
                         pwd VARCHAR(10),
                         name VARCHAR(50),
                         email VARCHAR(50),
                         joinDate DATE default current_timestamp
);


--회원 정보 추가
INSERT INTO t_member(id, pwd, name, email)
VALUES('hong', '1212', '홍길동', 'hong@gmail.com');

INSERT INTO t_member(id, pwd, name, email)
VALUES('lee', '1212', '이순신', 'lee@test.com');

INSERT INTO t_member(id, pwd, name, email)
VALUES('kim', '1212', '김유신', 'kim@jweb.com');
COMMIT;

SELECT * FROM t_member;