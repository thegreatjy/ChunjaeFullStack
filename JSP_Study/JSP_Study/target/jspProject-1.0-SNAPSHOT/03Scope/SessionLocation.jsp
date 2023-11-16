<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/8/23
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>페이지 이동 후 session 영역의 속성 읽기</h2>
  <%
    ArrayList<String> lists = (ArrayList<String>) session.getAttribute("lists");
    for(String str: lists){
      out.print(str + "<br>");
    }
  %>
</body>
</html>
