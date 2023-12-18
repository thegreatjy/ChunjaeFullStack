use mysql;
select host, user, password from user;
create user webuser;
create user 'webuser'@'localhost' identified by 'webuser';
-- create user 'webuser'@'%' identified by '12345'; --

create database webdb;

-- 특정 데이터베이스에 모든 권한 부여
grant all privileges on webdb.* to 'webuser'@'localhost';

use webdb;

create table tbl_todo(
                         tno int AUTO_INCREMENT PRIMARY KEY,
                         title varchar(100) not null,
                         dueDate date not null,
                         finished tinyint default 0
);

drop table tbl_todo;


create table tbl_member(
                           mid varchar(50) PRIMARY KEY,
                           mpw VARCHAR(50) not null,
                           mname VARCHAR(100) not NULL
);

insert into tbl_member(mid, mpw, mname) values('user00', '1111', '사용자0');
insert into tbl_member(mid, mpw, mname) values('user01', '1111', '사용자1');
insert into tbl_member(mid, mpw, mname) values('user02', '1111', '사용자2');

select *
from tbl_member
where mid = 'user00' and mpw = '1111';

alter table tbl_member add COLUMN uuid varchar(50);