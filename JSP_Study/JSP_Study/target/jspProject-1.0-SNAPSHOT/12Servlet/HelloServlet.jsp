<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/17/23
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello servlet</title>
</head>
<body>
    <h2>web.xml에서 맵핑 후 jsp에서 출력</h2>
    <p>
        <strong><%= request.getAttribute("message") %></strong>
        <br>
        <a href="./HelloServlet.do">바로가기</a>
    </p>
</body>
</html>
