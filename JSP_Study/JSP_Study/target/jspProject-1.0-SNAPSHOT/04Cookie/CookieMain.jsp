<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/9/23
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie</title>
</head>
<body>
  <h2>cookie 설정</h2>
  <%
    Cookie cookie = new Cookie("myCookie", "내가만든쿠키");
    cookie.setPath(request.getContextPath()); // context path: 프로젝트명. 웹 어플리케이션 전체에서 쿠키를 사용하겠다는 뜻.
    cookie.setMaxAge(3600);
    response.addCookie(cookie); // 응답 헤더에 쿠키 추가
  %>

  <h2>쿠키 설정 직후 쿠키 확인 </h2>
  <%
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
      for(Cookie c: cookies){
        String cookieName = c.getName();
        String cookieValue = c.getValue();

        out.println(String.format("%s : %s <br>", cookieName, cookieValue));
      }
    }
  %>

  <h2>페이지 이동 후 쿠키값 확인하기 </h2>
  <a href="CookieResult.jsp">
    다음 페이지에서 쿠키값 확인하기
  </a>
</body>
</html>
