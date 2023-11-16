<%@ page import="common.JDBConnect" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/7/23
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jdbc</title>
</head>
<body>
  <h2>회원 목록 조회 테스트 executeQuery() 사용 </h2>
  <%
    // DB 연결
    JDBConnect jdbc = new JDBConnect();

    // query
    String sql = "select id, pass, name, regidate from member";
    Statement stmt = jdbc.con.createStatement();

    // exec query
    ResultSet rs = stmt.executeQuery(sql);

    // result
    while(rs.next()){
      String id = rs.getString(1);
      String pw = rs.getString(2);
      String name = rs.getString("name");
      java.sql.Date regidate = rs.getDate("regidate");

      out.print(String.format("%s %s %s %s", id, pw, name, regidate)+"<br>");
    }

    // 연결 닫기
    jdbc.close();
  %>
</body>
</html>
