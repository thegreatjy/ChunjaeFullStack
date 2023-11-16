<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/15/23
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>영역을 통해 전달된 객체 읽기</h2>
  <ul>
    <li>Person 객체 - 이름:${requestScope.personObj.name}, 나이:${personObj.age}</li>
    <li>String 객체 - ${stringObj}</li> <!-- requestScope.stringObj 와 stringObj 둘 다 가능 -->
    <li>Integer 객체 - ${integerObj}</li>
  </ul>

  <h2>매개변수를 통해 전달된 객체 읽기</h2>
  <ul>
    <li>${ param.firstNum + param['secondNum'] }</li>
    <li>${ param.firstNum } + ${ param['secondNum'] }</li>
  </ul>
</body>
</html>
