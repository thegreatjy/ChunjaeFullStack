<%@ page import="common.DBConnPool" %>
<%@ page import="common.JDBConnect" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/13/23
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>커넥션 풀 테스트 </h2>
  <%
    JDBConnect conn = new JDBConnect();
    conn.close();
  %>

  <h2>JDBC 테스트 2</h2>
  <%
    String driver = application.getInitParameter("MySQL_Driver");
    String url = application.getInitParameter("MySQL_URL");
    String id = application.getInitParameter("MySQL_Id");
    String pwd = application.getInitParameter("MySQL_Pwd");

    JDBConnect jdbc2 = new JDBConnect(driver, url, id, pwd);
    jdbc2.close();
  %>

  <h2>JDBC 테스트 3</h2>
  <%
    JDBConnect jdbc3 = new JDBConnect(application);
    jdbc3.close();
  %>

  <h2>컨넥션 풀 테스트</h2>
  <%
    DBConnPool pool = new DBConnPool();
    pool.close();
  %>
</body>
</html>
