<%@ page import="model1.board.BoardDAO" %>
<%@ page import="model1.board.BoardDTO" %>
<%@ page import="utils.JSFunction" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/15/23
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String num = request.getParameter("num"); // 게시물 번호 얻기

  BoardDAO dao = new BoardDAO(application);
  BoardDTO board = new BoardDTO();
  board = dao.selectView(num); // DB에서 num의 게시물 객체 얻어옴

  // 로그인된 사용자 id 얻기
  String sessionId = session.getAttribute("UserId").toString();

  // 결과 확인
  int delResult = 0;

  // 로그인 한 사용자와 게시물 작성자가 동일한지 확인
  if(sessionId.equals(board.getId())){
    // 로그인 사용자 == 게시물 작성자
    delResult = dao.deletePost(board);
    dao.close();

    if(delResult == 1){
      // 삭제 성공
      // 글 목록 페이지로 이동
      JSFunction.alertLocation("삭제되었습니다. ", "List.jsp", out);
    }else{
      // 삭제 실패
      JSFunction.alertBack("삭제에 실패했습니다.", out);
    }
  }else{
    // 로그인 사용자 != 게시물 작성자
    JSFunction.alertBack("삭제하실 수 없습니다.", out);

    return;
  }

%>
