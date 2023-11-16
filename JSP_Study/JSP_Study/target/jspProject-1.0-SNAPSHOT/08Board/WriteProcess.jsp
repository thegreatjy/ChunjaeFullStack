<%@ page import="model1.board.BoardDTO" %>
<%@ page import="model1.board.BoardDAO" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/14/23
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Login 확인 -->
<%@ include file="./IsLoggedIn.jsp" %>

<%
  // 폼 값 받아오기
  String title = request.getParameter("title");
  String content = request.getParameter("content");

  // 폼 값을 DTO에 저장
  BoardDTO board = new BoardDTO();
  board.setTitle(title);
  board.setContent(content);
  board.setId(session.getAttribute("UserId").toString());

  // DB에 저장
  BoardDAO dao = new BoardDAO(application);
  int iResult = dao.insertWrite(board);
  dao.close();

  System.out.println(title);
  System.out.println(content);
  System.out.println(board.getTitle());
  System.out.println(board.getContent());

  // 게시글 DB 등록 성공 여부
  if(iResult == 1){
    response.sendRedirect("List.jsp");
  }else{
    JSFunction.alertBack("글쓰기에 실패하였습니다.", out);
  }
%>