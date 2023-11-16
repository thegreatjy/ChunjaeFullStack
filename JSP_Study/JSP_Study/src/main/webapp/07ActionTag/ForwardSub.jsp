<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/14/23
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forward sub</title>
</head>
<body>
    <h2>포워드 결과</h2>
    <ul>
        <li>
            page 영역 : <%= pageContext.getAttribute("pAttr")%>
        </li>
        <li>
            request 영역 : <%= request.getAttribute("rAttr")%>
        </li>
    </ul>
</body>
</html>
