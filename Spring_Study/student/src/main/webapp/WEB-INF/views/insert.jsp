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
    <title>Title</title>
</head>
<body>
<form action="/student/insert" method="post" enctype="application/x-www-form-urlencoded">
  <p>학번 : <input type="number" name="id" placeholder="학번" id="id" onblur="emailCheck()"></p>
  <p id="check-result"></p>
  <p>이름 : <input type="text" name="studentName" placeholder="이름"></p>
  <p>국어 : <input type="number" name="studentKoreanScore" placeholder="국어"></p>
  <p>영어 : <input type="number" name="studentEnglishScore" placeholder="영어"></p>
  <p>수학 : <input type="number" name="studentMathScore" placeholder="수학"></p>
  <input type="submit" value="입력">
  <input type="reset" value="초기화">
</form>
</body>
<script>
  function emailCheck(){};
</script>
</html>
