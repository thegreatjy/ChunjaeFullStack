use webdb;

create table test_student_table(
    studentId int primary key,
    studentNumber int unique,
    studentName varchar(10),
    studentKoreanScore int,
    studentEnglishScore int,
    studentMathScore int
);