<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/20/23
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>member auth</title>
</head>
<body>
  <h2>mvc 패턴으로 회원인증하기</h2>
  <p>
    <strong>${authMessage}</strong>
    <br>
    <a href="./MemberAuth.mvc?id=nakja&pass=1234">회원인증(관리자)</a>
    <a href="./MemberAuth.mvc?id=musthave&pass=1234">회원인증(회원)</a>
    <a href="./MemberAuth.mvc?id=stranger&pass=1234">회원인증(비회원)</a>
  </p>

<%= request.getContextPath() %>
  <a href="<%= request.getContextPath() %>/12Servlet/MemberAuth.mvc?id=nakja&pass=1234">회원인증(관리자)</a>
  <a href="<%= request.getContextPath() %>/12Servlet/MemberAuth.mvc?id=musthave&pass=1234">회원인증(회원)</a>
  <a href="<%= request.getContextPath() %>/12Servlet/MemberAuth.mvc?id=stranger&pass=1234">회원인증(비회원)</a>
</body>
</html>
