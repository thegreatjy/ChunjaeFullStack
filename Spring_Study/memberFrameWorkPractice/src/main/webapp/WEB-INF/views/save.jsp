<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 12/29/23
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Save</title>
</head>
<body>
    <p>${msg}</p>
    <%--@elvariable id="member" type="kr.co.chunjae.domain.MemberDTO"--%>
    <form:form modelAttribute="member" method="post" action="/member/save">
        <%--<p><form:errors path="*"/></p>--%>
        <p>아이디 : <form:input path="email" name="email" /> <form:errors path="email"/></p>
        <p>비밀번호 : <form:password path="password" name="password"/> <form:errors path="password"/></p>
        <p>이름 : <form:input path="name" name="name" /> <form:errors path="name"/></p>
        <p>나이 : <form:input path="age" name="age" /> <form:errors path="age"/></p>
        <p>전화번호 : <form:input path="mobile" name="mobile" /> <form:errors path="mobile"/></p>
        <input type="submit" value="가입하기"/>
        <input type="reset" value="다시작성"/>
    </form:form>
</body>
</html>
