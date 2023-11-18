<%@ page import="utils.JSFunction" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/14/23
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  if(session.getAttribute("UserId") == null){ // 로그인 되지 않음.
    JSFunction.alertLocation("로그인 후 이용해주십시오.", "../06Session/LoginForm.jsp", out);
    return;
  }
%>