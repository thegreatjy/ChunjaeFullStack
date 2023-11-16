<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/8/23
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="common.Person"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  pageContext.setAttribute("pageInteger", 1000);
  pageContext.setAttribute("pageString", "페이지 영역 문자열");
  pageContext.setAttribute("pagePerson", new Person("이지연", 26));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    int pInteger = (Integer)(pageContext.getAttribute("pageInteger"));
    String pString = pageContext.getAttribute("pageString").toString();
    Person pPerson = (Person)(pageContext.getAttribute("pagePerson"));
  %>
  <ul>
    <li>Integer 객체 : <%= pInteger %></li>
    <li>String 객체 : <%=pString%></li>
    <li>Person 객체 : <%=pPerson.getName()%>, <%=pPerson.getAge()%></li>
  </ul>


  <h2>include된 파일에서 page 영역 읽어오기</h2>
  <%@ include file="PageInclude.jsp" %>

  <a href="PageLocation.jsp">PageLocation.jsp</a>


</body>
</html>
