<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 12/20/23
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login</title>
    <!-- bootstrap 4 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar navbar-expand  navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="./home">Home</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">로그인</h1>
    </div>
</div>

<div class="container col-md-4">
    <div class="text-center">
        <h3 class="form-signin-heading">Please sign in</h3>
    </div>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            UserName과 Password가 올바르지 않습니다.<br />
        </div>
    </c:if>
    <form class="form-signin" action="<c:url value="/login"/>" method="post">
        <!-- id -->
        <div class="form-group row">
            <input type="text" name="username" class="form-control" placeholder="User Name" required autofocus>
        </div>
        <!-- pw -->
        <div class="form-group row">
            <input type="password" name="password" class="form-control"  placeholder="Password" required>
        </div>
        <!-- btn -->
        <div class="form-group row">
            <button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </div>
    </form>
</div>
</body>
</html>
