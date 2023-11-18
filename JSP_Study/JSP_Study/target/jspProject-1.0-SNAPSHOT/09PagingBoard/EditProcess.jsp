<%@ page import="model1.board.BoardDTO" %>
<%@ page import="model1.board.BoardDAO" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/15/23
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 로그인 확인 -->
<%@ include file="./IsLoggedIn.jsp"%>

<%
  // 수정한 내용 얻어오기
  // input form의 값을 읽어 온다.
  String num = request.getParameter("num");
  String title = request.getParameter("title");
  String content = request.getParameter("content");

  // 게시물 객체 생성
  BoardDTO board = new BoardDTO();
  board.setNum(num);
  board.setTitle(title);
  board.setContent(content);

  // 게시물 객체 DB에 갱신
  BoardDAO dao = new BoardDAO(application);
  int affected = dao.updateEdit(board);
  dao.close();

  // DB 갱신 성공 여부
  if(affected == 1){ // DB 갱신 성공
    response.sendRedirect("View.jsp?num=" + board.getNum());
  }else{
    JSFunction.alertBack("수정하기를 실패하였습니다.", out);
  }
%>