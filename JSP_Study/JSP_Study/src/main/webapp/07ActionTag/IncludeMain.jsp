<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/14/23
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String outerPath1 = "./inc/OuterPage1.jsp";
  String outerPath2 = "./inc/OuterPage2.jsp";

  // page, request 영역에 속성 저장
  pageContext.setAttribute("pAttr", "동명왕");
  request.setAttribute("rAttr", "온조왕");
%>
<html>
<head>
    <title>지시어 액션태그 비교 </title>
</head>
<body>
  <h2>지시어와 액션 태그 동작 방식 비교 </h2>

  <h3>지시어로 페이지 포함하기</h3>
  <%@include file="./inc/OuterPage1.jsp" %>
  <!-- %@include file="<%= outerPath1 %>" %> -->
  <!-- 지시어는 표현식 사용 불가 -->
  <p>외부 파일에 선언한 변수 : <%= newVar1 %></p>
  <!-- outerpage1.jsp에 선언된 변수를 불러올 수 있다. -->

  <h3>액션 태그로 페이지 포함하기</h3>
  <jsp:include page="./inc/OuterPage2.jsp" />
  <jsp:include page="<%=outerPath2%>"/>
  <!-- 지시어는 표현식 사용 가능 -->
  <!-- <p>외부 파일에 선언한 변수 : %= newVar2 %></p> -->
</body>
</html>
