<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 12/27/23
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<form action="/board/update" method="post" name="updateForm">
  <input type="hidden" name="id" value="${board.id}" readonly><br><br>
  <input type="text" name="boardWriter" value="${board.boardWriter}" readonly><br><br>
  <input type="text" name="boardPass" id="boardPass" placeholder="비밀번호 "><br><br>
  <input type="text" name="boardTitle" value="${board.boardTitle}"><br><br>
  <textarea name="boardContents" cols="30" rows="10">${board.boardContents}</textarea><br><br>
  <input type="button" value="수정" onclick="updateReqFn()"> </form>
</div>
</body>
<script>
  const updateReqFn = () => {
    const passInput = document.getElementById("boardPass").value;
    const passDB = '${board.boardPass}';
    if (passInput == passDB) {
      document.updateForm.submit(); }
    else {
      alert("비밀번호가 일치하지 않습니다!!"); }
  } </script>
</html>
