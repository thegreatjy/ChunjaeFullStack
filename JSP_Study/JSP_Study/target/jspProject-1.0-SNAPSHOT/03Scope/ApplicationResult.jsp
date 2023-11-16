<%@ page import="common.Person" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/8/23
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Map<String, Person> maps = (Map<String, Person>)application.getAttribute("maps");
        Set<String> keys = maps.keySet();

        for(String key: keys){
            Person person = maps.get(key);
            out.print(String.format("이름 : %s, 나이 : %d <br>", person.getName(), person.getAge()));
        }
    %>
</body>
</html>
