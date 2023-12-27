<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 12/27/23
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <td>${board.id}</td>
    </tr>
    <tr>
        <th>writer</th>
        <td>${board.boardWriter}</td>
    </tr>
    <tr>
        <th>date</th>
        <td>${board.boardCreatedTime}</td>
    </tr>
    <tr>
        <th>hits</th>
        <td>${board.boardHits}</td>
    </tr>
    <tr>
        <th>title</th>
        <td>${board.boardTitle}</td>
    </tr>
    <tr>
        <th>contents</th>
        <td>${board.boardContents}</td>
    </tr>
</table>
<button onclick="listFn()">목록</button>
<button onclick="updateFn()">수정</button>
<button onclick="deleteFn()">삭제</button>

<script>
    const listFn = function(){
        location.href = '/board/';
    }

    const updateFn = () =>{
        const id = "${board.id}";
        location.href = "/board/update?id="+id;
    }

    const deleteFn = () =>{
        const id = "${board.id}";
        location.href = "/board/delete?id="+id;
    }

</script>
</body>
</html>
