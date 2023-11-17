<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="common.Person" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/16/23
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>collection</title>
</head>
<body>
  <h2>list collection</h2>
  <%
    List<Object> aList = new ArrayList<>();
    aList.add("청해진");
    aList.add(new Person("장보고", 28));
    pageContext.setAttribute("Ocean", aList);
  %>

  <ul>
    <li>0번째 요소 : ${Ocean[0]}</li>
    <li>1번째 요소 : ${Ocean[1].name}, ${Ocean[1].age}</li>
    <li>2번째 요소 : ${Ocean[2]}</li> <!-- 출력되지 않음 -->
  </ul>

  <h2>map collection</h2>
  <%
    Map<String, String> map = new HashMap<>();
    map.put("한글", "훈민정음");
    map.put("Eng", "English");
    pageContext.setAttribute("King", map);
  %>
  <ul>
    <li>영문 key : ${King["Eng"]}, ${King['Eng']}, ${King.Eng}</li>
    <li>영문 key : ${King["한글"]}, ${King['한글']}</li> <!-- {King.한글} 오류 남 -->
  </ul>
</body>
</html>
