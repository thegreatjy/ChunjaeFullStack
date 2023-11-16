<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/9/23
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
  String chkVal = request.getParameter("inactiveToday");

  if(chkVal != null && chkVal.equals("1")){
    Cookie cookie = new Cookie("PopupClose", "off");
    cookie.setPath(request.getContextPath());
    cookie.setMaxAge(60);
    response.addCookie(cookie);

    out.println("쿠키 : 하루 동안 열지 않음");
  }
%>
</body>
</html>