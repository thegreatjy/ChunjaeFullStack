<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2024/01/04
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 </title>
</head>
<body>
    <p><c:out value="${msg}"/></p>

    <%--@elvariable id="memberDTO" type="kr.co.chunjae.domain.MemberDTO"--%>
    <form:form modelAttribute="memberDTO" action="/login" method="post">
        <p>ID: <form:input path="id" autofocos="true"/></p>
        <p>PW: <form:password path="password"/></p>
        <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
        <s:csrfInput />
        <form:button value="로그인">로그인 </form:button>
    </form:form>

</body>
</html>
