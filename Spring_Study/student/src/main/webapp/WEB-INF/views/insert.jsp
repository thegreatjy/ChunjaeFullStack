<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 12/22/23
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학생 등록</title>
</head>
<body>
<h3><a href="/">홈</a></h3>

<%--@elvariable id="StudentDTO" type="kr.co.chunjae.dto.StudentDTO"--%>
<form:form modelAttribute="StudentDTO" action="/student/insert" method="post" enctype="application/x-www-form-urlencoded">
  <p>학번 : <form:input path="studentNumber" type="number" name="studentNumber" id="studentNumber" autofocus="true" /></p>
  <p><form:errors path="studentNumber"/></p>
  <p>이름 : <form:input path="studentName" type="text" name="studentName" /></p>
  <p><form:errors path="studentName"/></p>

  <p>성별 : <label for="woman"><form:radiobutton path="studentGender" name="studentGender" id="woman" value="1" checked="true" />여자</label> <label for="man"><form:radiobutton path="studentGender" id="man" name="studentGender" value="2" />남자</label></p>
  <p><form:errors path="studentGender"/></p>

  <p>국어 : <form:input path="studentKoreanScore" type="number" name="studentKoreanScore" placeholder="국어"/></p>
  <p><form:errors path="studentKoreanScore"/></p>
  <p>영어 : <form:input path="studentEnglishScore" type="number" name="studentEnglishScore" placeholder="영어"/></p>
  <p><form:errors path="studentEnglishScore"/></p>
  <p>수학 : <form:input path="studentMathScore" type="number" name="studentMathScore" placeholder="수학"/></p>
  <p><form:errors path="studentMathScore"/></p>

  <input type="submit" value="입력">
  <input type="reset" value="초기화">
</form:form>
</body>
<script>
  // function emailCheck(){};
</script>
</html>
