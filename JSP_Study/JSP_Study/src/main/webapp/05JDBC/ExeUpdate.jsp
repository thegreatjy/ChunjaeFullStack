<%@ page import="common.JDBConnect" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/7/23
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jdbc</title>
</head>
<body>
    <h2> 회원 추가 테스트 executeUpdate() 사용 </h2>
    <%
        // db 연결
        JDBConnect jdbc = new JDBConnect();

        // 입력값
        String id = "test1";
        String pass = "1111";
        String name = "테스트 회원";

        // query
        String sql = "insert into member values(?,?,?, CURRENT_TIME)";
        PreparedStatement psmt = jdbc.con.prepareStatement(sql);
        psmt.setString(1, id);
        psmt.setString(2, pass);
        psmt.setString(3, name);

        // exec query
        int inResult = psmt.executeUpdate();
        out.println(inResult+"행이 입력되었습니다.");

        // 연결 닫기
        jdbc.close();
    %>
</body>
</html>
