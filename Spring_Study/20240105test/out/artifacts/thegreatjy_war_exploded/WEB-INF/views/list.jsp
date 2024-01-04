<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2024/01/04
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학점 관리</title>
</head>
<body>
    <h1>학점 관리</h1>
    <p>찾기 : <input type="text"/></p>
    <p><a href="/member/login">로그인</a> </p>
    <p><a href="/student/insert">학생 등록</a></p>

    <table>
        <tr>
            <td>학번</td>
            <td>이름</td>
        </tr>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td><a href="/student/detail?studentId=${student.studentId}"><c:out value="${student.studentNumber}"/></a> </td>
                <td><c:out value="${student.studentName}"/> </td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
