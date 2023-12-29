-- dcl --
create user 'memberframeworkuser'@'localhost' identified by 'memberframeworkuser';
create user 'memberframeworkuser'@'%' identified by 'memberframeworkuser';
create database memberframework DEFAULT CHARACTER SET = 'utf8mb4';
grant all privileges on memberframework.* to 'memberframeworkuser'@'%';
grant all privileges on memberframework.* to 'memberframeworkuser'@'localhost';


-- ddl --
drop table member;
create table member(
                       id int not null AUTO_INCREMENT PRIMARY key,
                       email varchar(50) not null unique,
                       password varchar(50) not null,
                       name varchar(30) not null,
                       age int not null,
                       mobile varchar(30) not null
);

-- dml --