<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/16/23
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>if</title>
</head>
<body>
  <c:set var="number" value="100"/>
  <c:set var="string" value="JSP"/>

  <h4>jstl의 if 태그로 짝수 홀수 판별하기</h4>
  <c:if test="${ number / 2 == 0 }" var="result">
    ${ number }는 짝수입니다. <br>
  </c:if>
  result : ${ result } <br>

  <h4>문자열 비교와 else 구문 흉내내기</h4>
  <c:if test="${ string == 'Java' }" var="result2">
    'Java'가 맞습니다. <br>
  </c:if>
  <c:if test="${ !result2 }">
    'Java'가 아닙니다. <br>
  </c:if>

  <h4>조건식 주의사항</h4>
  <c:if test="100" var="result3">
    el이 아닌 정수를 지정하면
  </c:if>
  result3 : ${ result3 } <br>

  <c:if test="tRuE" var="result4">
    대소문자 구분없이 tRuE인 경우 true <br>
  </c:if>
  result4 : ${ result4 } <br>

  <c:if test=" ${ true } " var="result5">
    el 양쪽에 빈 공백이 있는 경우 false <br>
  </c:if>
  result5 : ${ result5 }
</body>
</html>
