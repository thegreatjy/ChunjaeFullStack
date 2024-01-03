<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>점수 정정 및 삭제</title>
</head>
<body>
<h3><a href="/">홈</a></h3>

  <%--@elvariable id="StudentDTO" type="kr.co.chunjae.dto.StudentDTO"--%>
  <form:form modelAttribute="StudentDTO" action="/student/score/update" method="post" enctype="application/x-www-form-urlencoded">
    <form:hidden path="id"/>
    <p>학번 : <form:input path="studentNumber" type="number" name="studentNumber" id="studentNumber" readonly="true" /></p>
    <p>이름 : <form:input path="studentName" type="text" name="studentName" readonly="true" /></p>
    <p>국어 : <form:input path="studentKoreanScore" type="number" name="studentKoreanScore" placeholder="국어" autofocus="true" /></p>
    <p><form:errors path="studentKoreanScore"/></p>
    <p>영어 : <form:input path="studentEnglishScore" type="number" name="studentEnglishScore" placeholder="영어"/></p>
    <p><form:errors path="studentEnglishScore"/></p>
    <p>수학 : <form:input path="studentMathScore" type="number" name="studentMathScore" placeholder="수학"/></p>
    <p><form:errors path="studentMathScore"/></p>

    <input type="submit" value="수정">
    <input type="button" value="삭제" onclick="deleteStudent('${StudentDTO.id}')">
  </form:form>

</body>
<script>
  const update = () => {
    location.href = "/member/update";
  };

  const deleteStudent = (id) => {
    if (confirm("삭제하시겠습니까?") == true){
      //true는 확인버튼을 눌렀을 때 코드 작성
      console.log("완료되었습니다.");
      location.href = "/student/delete?id="+id;
    }else{
      // false는 취소버튼을 눌렀을 때, 취소됨
      console.log("취소되었습니다");
    }
  };
</script>
</html>