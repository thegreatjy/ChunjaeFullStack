<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/8/23
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="common.Person"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  int pInteger2 = (Integer)(pageContext.getAttribute("pageInteger"));
  Person person2 = (Person)(pageContext.getAttribute("pagePerson"));
%>

<ul>
  <li>Integer 객체 : <%= pInteger2 %></li>
  <li>String 객체 : <%= pageContext.getAttribute("pageString") %></li>
  <li>Person 객체 : <%= person2.getName() %>, <%=person2.getAge()%></li>
</ul>