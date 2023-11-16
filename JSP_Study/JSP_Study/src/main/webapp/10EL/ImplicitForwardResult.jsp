<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/15/23
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el 내장 객체</title>
</head>
<body>
    <h2>implicit forward result 페이지 </h2>
    <h3>각 영역에 저장된 속성 읽기</h3>
    <ul>
        <li>페이지 영역 : ${pageScope.scopeValue}</li>
        <li>리퀘스트 영역 : ${requestScope.scopeValue}</li>
        <li>페이지 영역 : ${sessionScope.scopeValue}</li>
        <li>페이지 영역 : ${applicationScope.scopeValue}</li>
    </ul>

    <h3>영역 지정 없이 속성 읽기</h3>
    <ul>
        <li>${scopeValue}</li>
    </ul>
</body>
</html>
