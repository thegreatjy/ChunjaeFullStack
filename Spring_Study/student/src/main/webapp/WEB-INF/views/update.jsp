<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>update</title>
</head>
<body>
<form action="/student/score/update" method="post" name="updateForm">
  학번 : <input type="number" name="id" value="${student.id}" readonly>
  이름 : <input type="text" name="studentName" value="${student.studentName}" readonly>
  국어 : <input type="number" name="studentKoreanScore" value="${student.studentKoreanScore}">
  영어 : <input type="number" name="studentEnglishScore" value="${student.studentEnglishScore}">
  수학 : <input type="number" name="studentMathScore" value="${student.studentMathScore}">
  <input type="submit" value="수정">
  <input type="button" value="삭제" onclick="deleteStudent('${student.id}')">
</form>
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