<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>update</title>
</head>
<body>
<%--@elvariable id="member" type="kr.co.chunjae.domain.MemberDTO"--%>
<form:form modelAttribute="member" action="/member/update" method="post" name="updateForm">
  <p>id: <form:input path="id" name="id" value="${member.id}" readonly="true" /> <form:errors path="id"/> </p>
  <p>email: <form:input path="email" name="email" value="${member.email}" readonly="true"/> <form:errors path="email"/> </p>
  <p>password: <form:password path="password" name="password"/> <form:errors path="password"/> </p>
  <p>name: <form:input path="name" name="name" value="${member.name}" readonly="true"/> <form:errors path="name"/> </p>
  <p>age: <form:input path="age" name="age" value="${member.age}"/> <form:errors path="age"/> </p>
  <p>mobile: <form:input path="mobile" name="mobile" value="${member.mobile}"/> <form:errors path="mobile"/> </p>

  <input type="button" value="수정" onclick="update()">
</form:form>
</body>

<script>
  // 기존 비밀번호와 일치했을 경우에만 회원정보 수정 가능
  const update = () => {
    const passwordDB = '${member.password}';
    const password = document.getElementById("password").value;

    if (passwordDB == password) {
      document.updateForm.submit();
    } else {
      alert("비밀번호가 일치하지 않습니다!");
    }
  }
</script>
</html>