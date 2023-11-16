<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/7/23
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="common.JDBConnect"%>
<%@ page import="common.DBConnPool" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head><title>JDBC</title></head>
<body>
<h2>JDBC 테스트 1</h2>
<%
  /*
  JDBConnect jdbc1 = new JDBConnect();
  jdbc1.close();
  */

  DBConnPool pool = new DBConnPool();
  pool.close();

%>
</body>
</html>

