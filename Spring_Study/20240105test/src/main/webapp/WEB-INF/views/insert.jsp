<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2024/01/04
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학생 등록</title>
</head>
<body>
<h2><a href="/student/list">홈</a></h2>

<%--@elvariable id="studentDTO" type="kr.co.chunjae.domain.StudentDTO"--%>
<form:form modelAttribute="studentDTO" method="post" action="/student/insert">
    <p>학번 : <form:input path="studentNumber" autofocus="true"/></p>
    <p><form:errors path="studentNumber"/></p>
    <p>이름 : <form:input path="studentName"/></p>
    <p><form:errors path="studentName"/></p>
    <p>국어 : <form:input path="studentKoreanScore" type="number" /></p>
    <p><form:errors path="studentKoreanScore"/></p>
    <p>영어 : <form:input path="studentEnglishScore" type="number" /></p>
    <p><form:errors path="studentEnglishScore"/></p>
    <p>수학 : <form:input path="studentMathScore" type="number" /></p>
    <p><form:errors path="studentMathScore"/></p>
    <input type="submit" value="입력">
    <input type="reset" value="초기화">
</form:form>
</body>
</html>
