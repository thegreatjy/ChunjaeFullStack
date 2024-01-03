<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>학점관리</title>
</head>
<body>
<h1>학점관리</h1>

<a href ="/student/login">로그인</a>
<a href ="/student/insert">학생등록</a>


<form method="post" action="/student/search">
    <span>찾기 : </span>
    <input type="text" name="id">
</form>

<table>
    <tr>
        <th>학번</th>
        <th>이름</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>
                <a href="/student/score/update?id=${student.id}">${student.studentNumber}</a>
            </td>
            <td>
                <a href="/student/score/update?id=${student.id}">${student.studentName}</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>