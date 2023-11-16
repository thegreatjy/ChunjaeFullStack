-- Active: 1697765718094@@127.0.0.1@3306@testtest
create database testtest;
use testtest;
create table member(
                       id varchar(10) not null,
                       pass varchar(10) not null,
                       name varchar(30) not null,
                       regidate date default CURRENT_TIME not null,
                       PRIMARY key(id)
);

create table board(
                      num int PRIMARY KEY,
                      title VARCHAR(200) not null,
                      content varchar(2000) not null,
                      id VARCHAR(10) not null,
                      postdate date DEFAULT CURRENT_TIME not null,
                      visitecount int
);

alter table board
    add constraint board_mem_fk FOREIGN KEY(id)
        REFERENCES member(id);

create sequence seq_board_num
    increment by 1	-- 1씩 증가
    start with 1	-- 1부터 시작
    minvalue 1		-- 최소 1
    nomaxvalue		-- 최대 무한대
	nocycle			-- 순환하지 않음
	nocache;

-- ch 5
insert into member(id, pass, name) values('musthave', '1234', 'mh');
insert into board(num, title, content, id) values(2, '제목', '내용', 'musthave');

-- ch
insert into board values(nextval(seq_board_num), '지금은 봄입니다.', '봄의왈츠', 'musthave', current_date, 0);
insert into board values(nextval(seq_board_num), '지금은 여름입니다.', '여름향기', 'musthave', current_date, 0);
insert into board values(nextval(seq_board_num), '지금은 가을입니다.', '가을동화', 'musthave', current_date, 0);
insert into board values(nextval(seq_board_num), '지금은 겨울입니다.', '겨울연가', 'musthave', current_date, 0);
commit;