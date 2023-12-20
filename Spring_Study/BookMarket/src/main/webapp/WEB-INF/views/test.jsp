<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="dataBean" action='result'>
  <form:select path="a1">
    <form:options items="${requestScope.data_list1}"/>
  </form:select>
</form:form>

<form:form modelAttribute="dataBean" action="result">
  <form:radiobuttons path="a2" items="${requestScope.data_list2}"/>
</form:form>
</body>
</html>