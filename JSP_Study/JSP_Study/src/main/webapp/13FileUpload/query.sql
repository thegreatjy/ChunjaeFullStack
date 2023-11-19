--파일 업로드와 다운로드를 위한 테이블 생성
drop table myfile;
create table myfile (
                        idx int primary key,
                        title varchar(200) not null,
                        cate varchar(100),
                        ofile varchar(100) not null,
                        sfile varchar(30) not null,
                        postdate date default now() not null
);