use webdb;

drop table if exists member_table;
create table member_table(
                             id bigint primary key auto_increment,
                             memberEmail varchar(20) unique,
                             memberPassword varchar(20),
                             memberName varchar(20),
                             memberAge int,
                             memberMobile varchar(30)
);

select * from member_table;


drop table if exists student_table;
create table student_table(
    id int primary key auto_increment,
    studentNumber int unique,
    studentName varchar(20),
    studentKoreanScore int,
    studentEnglishScore int,
    studentMathScore int
);

select * from student_table;
select id, studentName, studentKoreanScore, studentEnglishScore, studentMathScore
from student_table;