<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<p>${error}</p>

<%--@elvariable id="memberDTO" type="kr.co.chunjae.dto.MemberDTO"--%>
<form:form modelAttribute="memberDTO" action="/member/login" method="post">
    <label for="memberEmail">ID : </label>
    <form:input path="memberEmail" type="text" id="memberEmail" autofocus="true"/>

    <label for="memberPassword">PW : </label>
    <form:input path="memberPassword" type="password" id="memberPassword" />

    <input type="submit" value="로그인">
</form:form>
</body>
</html>