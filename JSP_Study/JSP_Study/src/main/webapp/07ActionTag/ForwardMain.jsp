<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/14/23
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  pageContext.setAttribute("pAttr", "김유신");
  request.setAttribute("rAttr", "계백");
%>
<html>
<head>
    <title>액션 태그-forward</title>
</head>
<body>
    <h2>액션 태그를 이용한 포워딩</h2>
    <jsp:forward page="./ForwardSub.jsp"></jsp:forward>
</body>
</html>
