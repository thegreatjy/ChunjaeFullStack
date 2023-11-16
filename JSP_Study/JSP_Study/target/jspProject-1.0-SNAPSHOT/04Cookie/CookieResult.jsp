<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/9/23
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie result</title>
</head>
<body>
  <h2>쿠키값 확인하기</h2>

  <%
    Cookie[] cookies = request.getCookies();

    if(cookies != null){
      for(int i=0; i< cookies.length; i++){
        String cookieName = cookies[i].getName();
        String cookieValue = cookies[i].getValue();
        out.println(String.format("쿠키명 : %s / 쿠키값 : %s <br>", cookieName, cookieValue));
      }
    }
  %>
</body>
</html>
