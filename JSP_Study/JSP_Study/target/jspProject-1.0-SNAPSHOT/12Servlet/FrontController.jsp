<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/17/23
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h3>한 번의 맵핑으로 여러 가지 요청 처리하기</h3>
  ${resultValue}
  <ol>
    <li>URI : ${uri}</li>
    <li>요청명 : ${commandStr}</li>
  </ol>
  <ul>
    <li><a href="../12Servlet/register.one">회원가입</a></li>
    <li><a href="../12Servlet/login.one">로그인</a></li>
    <li><a href="../12Servlet/freeboard.one">자유게시판</a></li>
  </ul>
</body>
</html>
