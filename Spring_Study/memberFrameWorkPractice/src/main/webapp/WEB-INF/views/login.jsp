<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2023/12/30
  Time: 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <%--@elvariable id="member" type="kr.co.chunjae.domain.MemberDTO"--%>
    <form:form modelAttribute="member" action="/member/login">
        <p>${msg}</p>
        <p>ID : <form:input path="email" name="email" placeholder="이메일" onfocus="this"/> </p>
        <p>PW : <form:password path="password" name="password" placeholder="비밀번호"/></p>
        <input type="submit" value="로그인"/>
    </form:form>
</body>
</html>
