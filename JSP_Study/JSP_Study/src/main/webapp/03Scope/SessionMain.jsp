<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/8/23
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  ArrayList<String> lists = new ArrayList<>();
  lists.add("리스트");
  lists.add("컬렉션");
  session.setAttribute("lists", lists);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>페이지 이동 후 session 영역의 속성 읽기</h2>
  <a href="SessionLocation.jsp">SessionLocation.jsp 바로가기</a>
</body>
</html>
