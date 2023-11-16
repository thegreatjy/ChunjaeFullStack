<%@ page import="common.Person" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/8/23
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    Map<String, Person> maps = new HashMap<>();
    maps.put("actor1", new Person("이수일", 30));
    maps.put("actor2", new Person("심순애", 28));
    maps.put("actor3", new Person("이수연", 25));

    application.setAttribute("maps", maps);
  %>
  application  영역에 속성이 저장되었습니다.
</body>
</html>
