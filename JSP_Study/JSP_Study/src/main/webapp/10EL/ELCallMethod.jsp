<%@ page import="el.MyELClass" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/16/23
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/MyTagLib.tld" %>
<%
  MyELClass myClass = new MyELClass();
  pageContext.setAttribute("myClass", myClass);
%>
<html>
<head>
    <title>el method</title>
</head>
<body>
  <h3>영역에 저장 후 메서드 출력</h3>
  001225-3000000 => ${myClass.getGender("001225-3000000")} <br>
  001225-2000000 => ${myClass.getGender("001225-2000000")} <br>

  <h3>클래스명을 통해 정적 메서드 호출</h3>
  ${MyELClass.showGugudan(7)}

  <h3>tld 파일 등록 후, 정적 메서드 호출 </h3>
  <ul>
    <li>mytag:isNumber("100") -> ${mytag:isNumber("100")}</li>
    <li>mytag:isNumber("이백") -> ${mytag:isNumber("이백")}</li>
  </ul>
</body>
</html>
