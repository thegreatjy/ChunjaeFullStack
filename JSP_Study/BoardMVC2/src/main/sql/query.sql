CREATE DATABASE boardmvc2
    DEFAULT CHARACTER SET = 'utf8mb4';
use boardmvc2;

-- mvcboard 테이블
create table mvcboard (
                          idx int primary key AUTO_INCREMENT,
                          name varchar(50) not null,
                          title varchar(200) not null,
                          content varchar(2000) not null,
                          postdate date default now() not null,
                          ofile varchar(200),
                          sfile varchar(30),
                          downcount int default 0 not null,
                          pass varchar(50) not null,
                          visitcount int default 0 not null
);
-- change password datatype for encryption
ALTER TABLE mvcboard MODIFY pass varchar(64);

--더미 데이터 입력
insert into mvcboard (name, title, content, pass)
values ('김유신', '자료실 제목1 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
values ('장보고', '자료실 제목2 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
values ('이순신', '자료실 제목3 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
values ('강감찬', '자료실 제목4 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
values ('대조영', '자료실 제목5 입니다.','내용','1234');

commit;

-- selectCount
select Tb.*
from (
         select *
         from mvcboard
         where title like '%자료실%'
         order by idx desc
     ) as Tb
limit 10 offset 3;