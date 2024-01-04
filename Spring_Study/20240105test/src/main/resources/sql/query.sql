use webdb;

drop table if exists test_student_table;
create table test_student_table(
    studentId int primary key auto_increment,
    studentNumber int unique,
    studentName varchar(10),
    studentKoreanScore int,
    studentEnglishScore int,
    studentMathScore int
);

create table test_member_table(
    memberIdx int primary key auto_increment,
    memberId varchar(50),
    memberpassword varchar(50)
);

insert into test_member_table(memberId, memberpassword) values("test", "test");