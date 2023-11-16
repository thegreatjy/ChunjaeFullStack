<%@ page import="utils.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/13/23
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // loginId 쿠키를 읽어온다.
    // input 박스 기본값으로 대입된다.
    String loginId = CookieManager.readCookie(request, "loginId");

    // 쿠키 값이 빈 문자열이 아닌 저장된 아이디가 있다면, 체크박스에 체크 표시
    String cookieCheck = "";
    if(!loginId.equals("")){
        cookieCheck = "checked";
    }
%>
<html>
<head>
    <title>cookie id 저장 </title>
</head>
<body>
    <form action="IdSaveProcess.jsp" method="post">
        아이디 : <input type="text" name="user_id" value="<%= loginId%>"/>
        <input type="checkbox" name="save_check" value="Y" <%= cookieCheck %> /> 아이디 저장하기
        <br>
        패스워드 : <input type="text" name="user_pw"/>
        <br>
        <input type="submit" value="로그인하기"/>
    </form>
</body>
</html>
