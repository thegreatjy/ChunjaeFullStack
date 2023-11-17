<%@ page import="java.util.Date" %>
<%@ page import="common.Person" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/16/23
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>set 1</title>
</head>
<body>
    <!-- 변수 설정 -->
    <c:set var="directVar" value="100"/>
    <c:set var="elVar" value="${ directVar mod 5}"/>
    <c:set var="expVar" value="<%= new Date() %>"/>
    <c:set var="betweenVar">변수값 이렇게 설정</c:set>

    <h4>el을 이용해 변수 출력</h4>
    <ul>
        <li>directVar : ${ pageScope.directVar }</li>
        <li>elVar : ${ elVar }</li>
        <li>expVar : ${ expVar }</li>
        <li>betweenVar : ${ betweenVar }</li>
    </ul>

    <h4>자바빈즈 생성 1 - 생성자 사용</h4>
    <c:set var="personVar1" value='<%= new Person("이지연", 26) %>' scope="request" />
    <ul>
        <li>이름 : ${ requestScope.personVar1.name }</li>
        <li>나이 : ${ requestScope.personVar1.age }</li>
    </ul>

    <h4>자바빈즈 생성 2 - target, property 사용</h4>
    <c:set var="personVar2" value="<%= new Person() %>" scope="request"/>
    <c:set target="${personVar2}" property="name" value="이지연2" /> <!-- 객체 생성 이후 나중에 값 설정 -->
    <c:set target="${personVar2}" property="age" value="50" />
    <ul>
        <li>이름 : ${ personVar2.name }</li>
        <li>나이 : ${ requestScope.personVar2.age }</li>
    </ul>
</body>
</html>
