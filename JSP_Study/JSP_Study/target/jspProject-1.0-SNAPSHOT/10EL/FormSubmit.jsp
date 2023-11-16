<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/15/23
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>폼값 전송하기</h2>
  <form name="frm" method="post" action="FormResult.jsp">
    이름 : <input type="text" name="name"><br>
    성별 : <input type="radio" name="gender" value="man"> 남자
          <input type="radio" name="gender" value="woman"> 여자<br>
    학력 : <select name="grade">
            <option value="ele">초등</option>
            <option value="mid">중등</option>
            <option value="high">고등</option>
            <option value="uni">대학</option>
          </select><br>
    관심사항 :
      <input type="checkbox" name="inter" value="pol">정치
      <input type="checkbox" name="inter" value="eco">경제
      <input type="checkbox" name="inter" value="ent">연예
      <input type="checkbox" name="inter" value="spo">운동 <br>
    <input type="submit" value="전송하기">
  </form>
</body>
</html>
