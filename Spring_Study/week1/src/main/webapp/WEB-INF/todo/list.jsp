<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 12/8/23
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
  <h1>list page</h1>

  <ul>
      <c:forEach var="dto" items="${list}">
          <li>${dto}</li>
      </c:forEach>
  </ul>

</body>
</html>
