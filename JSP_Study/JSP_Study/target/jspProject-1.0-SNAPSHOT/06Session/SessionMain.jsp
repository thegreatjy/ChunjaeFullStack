<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/13/23
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  long creationTime = session.getCreationTime(); // 세션 생성 시각
  String creationTimeStr = dateFormat.format(new Date(creationTime));

  long lastTime = session.getLastAccessedTime();
  String lastTimeStr = dateFormat.format(new Date(lastTime));

  session.setMaxInactiveInterval(60);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>세션 설정 확인</h2>
  <ul>
    <li>세션 유지 시간 : <%= session.getMaxInactiveInterval() %></li>
    <li>세션 아이디 : <%= session.getId() %></li>
    <li>최초 요청 시각 : <%= creationTimeStr %></li>
    <li>마지막 요청 시간 : <%= lastTimeStr %></li>
  </ul>

</body>
</html>
