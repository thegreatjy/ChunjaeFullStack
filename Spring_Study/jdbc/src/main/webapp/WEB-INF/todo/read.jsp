<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 12/13/23
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read</title>
</head>
<body>
  <div>
    <input type="text" name="tno" value="${dto.tno}" readonly>
  </div>

  <div>
    <input type="text" name="title" value="${dto.title}" readonly>
  </div>

  <div>
    <input type="date" name="dueDate" value="${dto.dueDate}" readonly>
  </div>

  <div>
    <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} readonly>
  </div>

  <div>
    <a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>
    <a href="/todo/list">List</a>
  </div>
</body>
</html>
