<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2024/01/04
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학생 성적 정정</title>
</head>
<body>
<h2><a href="/student/list">홈</a></h2>

<%--@elvariable id="studentDTO" type="kr.co.chunjae.domain.StudentDTO"--%>
<form:form modelAttribute="studentDTO" method="post" action="/student/update">
    <form:hidden path="studentId"/>
    <p>학번 : <form:input path="studentNumber" readonly="true"/></p>
    <p>이름 : <form:input path="studentName" readonly="true"/></p>
    <p>국어 : <form:input path="studentKoreanScore" type="number" /></p>
    <p><form:errors path="studentKoreanScore"/></p>
    <p>영어 : <form:input path="studentEnglishScore" type="number" /></p>
    <p><form:errors path="studentEnglishScore"/></p>
    <p>수학 : <form:input path="studentMathScore" type="number" /></p>
    <p><form:errors path="studentMathScore"/></p>
    <input type="submit" value="수정">
    <input type="button" value="삭제" onclick="deleteFn(${studentDTO.studentId})">
</form:form>

<script>
    const deleteFn = (id) => {
        let studentId = id;

        location.href = "/student/delete?studentId=" + studentId;
    };
</script>
</body>
</html>
