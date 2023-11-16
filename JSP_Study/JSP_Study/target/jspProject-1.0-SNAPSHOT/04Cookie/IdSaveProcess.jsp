<%@ page import="utils.CookieManager" %>
<%@ page import="utils.JSFunction" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/13/23
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- 로그인 성공 여부 판별 및 아이디 저장하기 체크되어 있으면 쿠키 생성 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String user_id = request.getParameter("user_id");
  String user_pw = request.getParameter("user_pw");
  String save_check = request.getParameter("save_check");

  // 로그인 성공 시
  if("must".equals(user_id) && "1234".equals(user_pw)){
    // 아이디 기억하기 버튼이 눌린 채로 로그인 성공 시
    if(save_check != null && save_check.equals("Y")){
      CookieManager.makeCookie(response, "loginId", user_id, 86400);
    }else{
      CookieManager.deleteCookie(response, "loginId");
    }

    JSFunction.alertLocation("로그인에 성공했습니다.", "IdSaveMain.jsp", out);
  }else { // 로그인 실패 시
    JSFunction.alertBack("로그인에 실패했습니다.", out);
  }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
