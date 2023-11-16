<%@ page import="common.Person" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/8/23
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("requestString", "request 영역의 문자열");
    request.setAttribute("requestPerson", new Person("이지연", 26));
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>request 영역의 속성값 삭제하기</h2>
    <%
        request.removeAttribute("requestString");
        request.removeAttribute("requestInteger"); // 에러 x
    %>

    <h2>request 영역의 속성값 읽기 </h2>
    <%
        Person rPerson = (Person)(request.getAttribute("requestPerson"));
    %>
    <ul>
        <li>String 객체 : <%=request.getAttribute("requestString")%></li>
        <li>Person 객체 : <%=rPerson.getName()%> , <%=rPerson.getAge()%></li>
    </ul>

    <h2>포워드된 페이지에서 request 영역 속성값 읽기</h2>

    <% request.getRequestDispatcher("RequestForward.jsp?paramHan=한글&paramEng=English").forward(request, response); %>
</body>
</html>
