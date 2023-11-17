<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/16/23
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <c:set var="requestVar" value="MustHave" scope="request" />
  <c:redirect url="/11JSTL/inc/Redirect.jsp">
    <c:param name="user_param1" value="출판사" />
    <c:param name="user_param2" value="골든래빗" />
  </c:redirect>
</body>
</html>
