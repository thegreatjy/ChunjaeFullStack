<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/member/login" method="post">
    <label for="input_id">ID : </label>
    <input type="text" id="input_id">

    <label for="input_pw">PW : </label>
    <input type="text" id="input_pw">

    <input type="submit" value="로그인">
</form>
</body>
</html>