<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/14/23
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 로그인 확인 -->
<%@ include file="./IsLoggedIn.jsp" %>

<html>
<head>
  <title>회원제 게시판 write</title>
  <script type="text/javascript">
    function validateForm(form){
      if(form.title.value == ""){
        alert("제목을 입력하세요.");
        form.title.focus();
        return false;
      }

      if(form.content.value == ""){
        alert("내용을 입력하세요.");
        form.content.focus();
        return false;
      }
    }

    <!-- 뒤로가기로 현재 페이지를 요청했을 때, 입력되어 있는 폼을 초기화한다. -->
    window.onpageshow = function(event) {
      //back 이벤트 일 경우
      if (event.persisted) {
        location.reload(true);
      }
    }
  </script>
</head>
<body>
  <jsp:include page="../Common/Link.jsp" />
  <h2>회원제 게시판 - 글쓰기 페이지 </h2>
  <form name="writeFrm" method="post" action="./WriteProcess.jsp" onsubmit="return validateForm(this);">
    <table border="1" width="90%">
      <tr>
        <td>제목</td>
        <td>
          <input type="text" name="title" style="width: 90%;" />
        </td>
      </tr>
      <tr>
        <td>내용</td>
        <td><textarea name="content" style="width: 90%; height: 100px;"></textarea>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <button type="submit">작성 완료</button>
          <button type="reset">다시 입력</button>
          <button type="button" onclick="location.href='./List.jsp';">목록 보기</button>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>
