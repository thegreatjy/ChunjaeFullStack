<%@ page import="common.Person" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/15/23
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el obj param</title>
</head>
<body>
  <%
    request.setAttribute("personObj", new Person("이지연", 26));
    request.setAttribute("stringObj", "나는 문자열");
    request.setAttribute("integerObj", new Integer(99));
  %>

<jsp:forward page="ObjectResult.jsp">
  <jsp:param value="10" name="firstNum"></jsp:param>
  <jsp:param value="20" name="secondNum"></jsp:param>
</jsp:forward>
</body>
</html>
