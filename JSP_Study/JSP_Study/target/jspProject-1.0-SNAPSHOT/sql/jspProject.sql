-- Active: 1698575370619@@127.0.0.1@3306@musthave
-- Active: 1697765718094@@127.0.0.1@3306@musthave
use musthave;

DROP TABLE IF EXISTS member;
CREATE TABLE member(
                       id varchar(10) NOT NULL,
                       pass varchar(10) NOT NULL,
                       name varchar(10) NOT NULL,
                       register date DEFAULT (current_date) NOT NULL,
                       PRIMARY key(id)
);

DROP TABLE IF EXISTS board;
CREATE TABLE board(
                      num int PRIMARY KEY AUTO_INCREMENT,
                      title varchar(20) NOT NULL,
                      content varchar(200) NOT NULL,
                      id varchar(10) NOT NULL,
                      postdate date DEFAULT (current_date) NOT NULL,
                      visitcount decimal(6) DEFAULT 0
);
alter table board CHANGE COLUMN postate postdate date;
alter table board modify COLUMN postdate date DEFAULT curdate();
alter table board MODIFY COLUMN visitcount decimal(6) DEFAULT 0;

ALTER TABLE board ADD CONSTRAINT board_mem_fk FOREIGN KEY (id) REFERENCES member(id);

INSERT INTO member(id, pass, name) values('musthave', '1234', '머스트해브');
INSERT INTO member(id, pass, name) values('1', '1', '머스트해브');
SELECT * FROM member;


SELECT * FROM board;

create sequence seq_board_num
    increment by 1	-- 1씩 증가
    start with 1	-- 1부터 시작
    minvalue 1		-- 최소 1
    nomaxvalue		-- 최대 무한대
	nocycle			-- 순환하지 않음
	nocache;		-- 캐시 안  함

insert into board values(nextval(seq_board_num), '지금은 봄입니다.', '봄의왈츠', 'musthave', current_date, 0);
insert into board values(nextval(seq_board_num), '지금은 여름입니다.', '여름향기', 'musthave', current_date, 0);
insert into board values(nextval(seq_board_num), '지금은 가을입니다.', '가을동화', 'musthave', current_date, 0);
insert into board values(nextval(seq_board_num), '지금은 겨울입니다.', '겨울연가', 'musthave', current_date, 0);
insert into board values(nextval(seq_board_num), '지금은 겨울입니다.', '겨울연가', 'musthave', current_date, 0);
commit;

-- 이 쿼리 반복
insert into board values(nextval(seq_board_num), '지금은 겨울입니다.', '겨울연가', 'musthave', current_date, 0);

select * from board order by num desc;


select A.*
from(
        select CONVERT(@rownum:=@rownum+1, SIGNED) rownumber, t.*
        from board as t
        where(@rownum := 0) = 0 and title like '%%') as A
where rownumber BETWEEN 1 and 20
order by A.rownumber desc;

select * from board order by num desc limit 10 offset 0;
-- select * from board order by num desc limit (한 페이지당 게시물 개수) offset (총 게시물 개수 - (페이지번호-1)*한 페이지당 글 개수)(=맨 위 게시물 번호);--
