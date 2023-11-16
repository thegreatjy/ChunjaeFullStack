<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/14/23
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>outerpage 2</title>
</head>
<body>
    <h2>외부파일</h2>
    <%
        String newVar2 = "백제 온조왕";
    %>
    <ul>
        <li>page 영역 속성 : <%=pageContext.getAttribute("pAttr")%></li>
        <li>request 영역 속성 : <%=request.getAttribute("rAttr")%></li>
    </ul>
</body>
</html>
