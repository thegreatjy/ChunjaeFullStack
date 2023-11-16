<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/14/23
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>outerpage</title>
</head>
<body>
  <h2>외부파일 1</h2>
  <%
    String newVar1 = "고구려 세운 동명왕";
  %>
  <ul>
    <li>page 영역 속성 : <%=pageContext.getAttribute("pAttr")%></li>
    <li>request 영역 속성 : <%=request.getAttribute("rAttr")%></li>
  </ul>
</body>
</html>
