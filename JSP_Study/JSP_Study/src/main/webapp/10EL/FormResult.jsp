<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/15/23
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form result</title>
</head>
<body>
  <h3>el로 폼 값 받기</h3>
  <ul>
    <li>이름 : ${param.name}</li>
    <li>성별 : ${param.gender}</li>
    <li>학력 : ${param.grade}</li>
    <li>관심사항 :
      ${paramValues.inter[0] }
      ${paramValues.inter[1] }
      ${paramValues.inter[2] }
      ${paramValues.inter[3] }
    </li>
  </ul>
</body>
</html>
