<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<c:out value="${error}"/>
<c:out value="${logout}"/>

<form action="./customlogin" method="post">
    <label for="username">ID : </label>
    <input type="text" id="username" name="username">

    <label for="password">PW : </label>
    <input type="password" id="password" name="password">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <input type="submit" value="로그인">
</form>
</body>
</html>