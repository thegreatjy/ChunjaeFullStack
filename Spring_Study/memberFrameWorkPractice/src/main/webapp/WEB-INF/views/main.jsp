<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 2023/12/30
  Time: 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
    <h2>${sessionScope.loginEmail}님 환영합니다.</h2>
    <button onclick="update()">내정보 수정하기</button>
    <button onclick="logout()">로그아웃</button>

    <script>
        // 내 정보 수정하기
        const update = () => {
            location.href = "/member/update";
        };

        // 로그아웃
        const logout = () => {
            location.href = "/member/logout";
        };
    </script>
</body>
</html>
