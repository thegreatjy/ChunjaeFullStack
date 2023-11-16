<%@ page import="membership.MemberDAO" %>
<%@ page import="membership.MemberDTO" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/13/23
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // 로그인 폼으로부터 받은 아이디, 패스워드
  String userId = request.getParameter("user_id");
  String userPwd = request.getParameter("user_pw");

  // WEB-INF/web.xml에서 가져온 데이터베이스 연결 정보
  String driver = application.getInitParameter("MySQL_Driver");
  String url = application.getInitParameter("MySQL_URL");
  String id = application.getInitParameter("MySQL_Id");
  String pwd = application.getInitParameter("MySQL_Pwd");

  // 회원 테이블 DAO를 통해 회원 정보 DTO
  MemberDAO dao = new MemberDAO(driver, url, id, pwd);
  MemberDTO memberDTO = dao.getMemberDTO(userId, userPwd);
  dao.close();

  // 로그인 성공 여부에 따른 처리
  if(memberDTO.getId() != null){ // 로그인 성공
    session.setAttribute("UserId", memberDTO.getId());
    session.setAttribute("UserName", memberDTO.getName()); // session 영역에 저장된 속성값은 포워드된 페이지까지 공유된다.
    response.sendRedirect("LoginForm.jsp");
  }else{ // 로그인 실패
    request.setAttribute("LoginErrMsg", "로그인 오류입니다.");
    request.getRequestDispatcher("LoginForm.jsp").forward(request, response); // loginform.jsp로 포워딩한다. request 영역에 저장된 속성값은 포워드된 페이지까지 공유된다.
  }
%>

