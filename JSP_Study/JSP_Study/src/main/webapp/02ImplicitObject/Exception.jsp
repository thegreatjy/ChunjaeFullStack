<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/7/23
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>내장객체 exception</title>
</head>
<body>
    <%
        int status = response.getStatus();

        if(status == 404){
            out.print("404 에러 발생");
            out.print("<br>파일 경로 확인");
        }else if(status == 405){
            out.print("405 에러 발생");
            out.print("<br>요청 방식 확인");
        }else if(status == 500){
            out.print("500 에러 발생");
            out.print("<br>소스 코드 오류 확인");
        }
    %>
</body>
</html>
