<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/13/23
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // 방법 1 : 회원 인증 정보 속성 삭제
  session.removeAttribute("UserId");
  session.removeAttribute("UserName");

  // 방법 2 : 모든 속성 한꺼번에 삭제
  session.invalidate(); // 세션 자체를 무효화한다. session 영역의 모든 속성을 삭제한다.

  // 속성 삭제 후, 페이지 이동
  response.sendRedirect("LoginForm.jsp");
%>