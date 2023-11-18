<%@ page import="model1.board.BoardDAO" %>
<%@ page import="model1.board.BoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/14/23
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String num = request.getParameter("num"); // 일련번호 받기

  BoardDAO dao = new BoardDAO(application);
  // num 게시물 번호 가진 게시물의 조회수 1 증가
  dao.updateVisitCount(num);
  // num 게시물 번호를 가진 게시물 하나 리턴
  BoardDTO board = dao.selectView(num);
%>
<html>
<head>
    <title>회원제 게시판 view</title>
  <script>
    function deletePost(){
      // 삭제 요청
      var confirmed = confirm("정말로 삭제하시겠습니까?");
      if(confirmed){
        var form = document.writeFrm; // name=writeFrm인 폼 선택
        form.method="post";
        form.action="DeleteProcess.jsp";
        form.submit();
      }
    }
  </script>
</head>
<body>
  <!-- 네비게이션 바 -->
  <jsp:include page="../Common/Link.jsp"/>

  <h2>회원제 게시판 - 상세 보기 (view)</h2>

  <form name="writeFrm">
    <input type="hidden" name="num" value="<%= num %>" />
    <table border="1" width="90%">
      <tr>
        <td>번호</td>
        <td><%= board.getNum() %></td>
        <td>작성자</td>
        <td><%= board.getName() %></td>
      </tr>
      <tr>
        <td>작성일</td>
        <td><%= board.getPostdate() %></td>
        <td>조회수</td>
        <td><%= board.getVisitcount() %></td>
      </tr>
      <tr>
        <td>제목</td>
        <td colspan="3"><%= board.getTitle() %></td>
      </tr>
      <tr>
        <td>내용</td>
        <td colspan="3" height="100">
          <!-- 엔터키를 <br>태그로 변환하여 웹 뷰에서 줄바꿈 적용 -->
          <%= board.getContent().replace("\r\n", "<br>") %>
        </td>
      </tr>
      <!-- 수정, 삭제, 목록 보기 버튼 -->
      <tr>
        <td colspan="4" align="center">
          <!-- 세션에 로그인 된 아이디와 게시물 작성자 아이디와 동일하면 수정, 삭제 버튼 출력 -->
          <%
            if(session.getAttribute("UserId") != null && session.getAttribute("UserId").toString().equals(board.getId())){
          %>
          <button type="button" onclick="location.href='Edit.jsp?num=<%= board.getNum() %>';">수정하기</button>
          <button type="button" onclick="deletePost();">삭제하기</button>
          <%
            }
          %>
          <button type="button" onclick="location.href='List.jsp';">
            목록 보기
          </button>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>
