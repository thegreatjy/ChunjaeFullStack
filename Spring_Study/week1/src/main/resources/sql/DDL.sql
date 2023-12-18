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