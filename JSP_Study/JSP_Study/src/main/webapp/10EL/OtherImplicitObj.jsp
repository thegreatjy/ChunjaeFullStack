<%@ page import="utils.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/16/23
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  CookieManager.makeCookie(response, "ELCookie", "EL좋아요", 10);
%>
<html>
<head>
    <title>el </title>
</head>
<body>
  <h3>쿠키값 읽기</h3>
  <li>el cookie : ${cookie.ELCookie.value} </li>

  <h3>http 헤더 읽기</h3>
  <ul>
    <li>host : ${header.host}</li>
    <li>user-agent : ${header['user-agent']}</li>
    <li>cookie : ${header.cookie}</li>
  </ul>

  <h3>컨텍스트 초기화 매개변수 읽기</h3>
  <li>oracle driver : ${initParam}</li>

  <h3>컨텍스트 루트 경로 읽기</h3>
  <li>${pageContext.request.contextPath}</li>
</body>
</html>
