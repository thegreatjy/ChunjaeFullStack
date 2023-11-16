<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/13/23
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="../Common/Link.jsp"/>
    <h2>로그인 페이지</h2>
    <span style="color: red; font-size:1.2em;">
        <%= request.getAttribute("LoginErrMsg") == null ? "" : request.getAttribute("LoginErrMsg")%>
    </span>
    <%
        // 로그인 상태 확인
        if(session.getAttribute("UserId") == null){
            // 로그아웃 상태
    %>
    <script>
        function validateForm (form){
            if(!form.user_id.value){
                alert("아이디를 입력하세요");
                return false;
            }
            if(form.user_pw.value == ""){
                alert("패스워드를 입력하세요.");
                return false;
            }
        }
    </script>
    <form action="LoginProcess.jsp" method="post" name="loginFrm"
          onsubmit="return validateForm(this);">
        아이디 : <input type="text" name="user_id"><br>
        패스워드 : <input type="password" name="user_pw"><br>
        <input type="submit" value="로그인하기"/>
    </form>
    <%
        }else{ // 로그인 된 상태
    %>
        <%= session.getAttribute("UserName")%> 회원님, 로그인하셨습니다. <br>
        <a href="Logout.jsp">[로그아웃]</a>
    <%
        }
    %>
</body>
</html>
