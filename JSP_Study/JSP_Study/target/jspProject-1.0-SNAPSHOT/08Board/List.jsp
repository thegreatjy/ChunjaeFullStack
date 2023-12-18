<%@ page import="model1.board.BoardDAO" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="model1.board.BoardDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 11/14/23
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // DB 연결 객체
  BoardDAO dao = new BoardDAO(application);

  // 사용자가 입력한 검색 조건을 Map에 저장
  Map<String, Object> param = new HashMap<String, Object>();

  String searchField = request.getParameter("searchField");
  String searchWord = request.getParameter("searchWord");

  if(searchWord != null){
    param.put("searchField", searchField);  // 검색 카테고리(제목, 내용)
    param.put("searchWord", searchWord);    // 검색어
  }

  // 검색 결과에 해당하는 게시글 개수
  int totalCount = dao.selectCount(param);
  // 검색 결과 (게시글)
  List<BoardDTO> boardList = dao.selectList(param);
  dao.close();
%>
<html>
<head>
    <title>회원제 게시판</title>
  <style>
    table, tr, td{
      border: 1px solid black;
    }
    table{
      width: 90%;
    }

    .width10{
      width: 10%;
      text-align: center;
    }

    .width15{
      width: 15%;
    }

    .align-left{
      text-align: left;
    }
    .align-center{
      text-align: center;
    }
    .align-right{
      text-align: right;
    }
  </style>
</head>
<body>
  <!-- 네비게이션 바 -->
  <jsp:include page="../Common/Link.jsp" />

  <h2>목록 보기(List)</h2>
  <!-- 검색 입력폼 -->
    <table>
      <tr>
        <td class="align-center">
          <form method="get">
            <!-- 검색 종류 옵션 선택 (제목, 내용) -->
            <select name="searchField">
              <option value="title">제목</option>
              <option value="content">내용</option>
            </select>
            <input type="text" name="searchWord" />
            <button type="submit">검색하기</button>
          </form>
        </td>
      </tr>
    </table>


  <!-- 게시물 목록 테이블 -->
  <table>
    <!-- 컬럼의 이름 -->
    <tr>
      <td class="width10">번호</td>
      <td class="width10">제목</td>
      <td class="width15 align-center">작성자</td>
      <td class="width10">조회수</td>
      <td class="width15 align-center">작성일</td>
    </tr>
    <!-- 목록 내용 -->
    <%
      // 게시글 목록에 등록된 게시글이 아무것도 없을 때
      if(boardList.isEmpty()){
    %>
      <tr>
        <td colspan="5" text-align="center">
          등록된 게시글이 없습니다.
        </td>
      </tr>
    <%
      // 게시글 목록에 글이 있을 때
      }else{
        int virtualNum = 0; // 화면상에서의 게시글 번호. 임의로 0으로 초기화
        for(BoardDTO board: boardList){
          virtualNum = totalCount--;
    %>
        <tr class="align-center">
          <!-- 게시글 번호 -->
          <td>
            <%=virtualNum%>
          </td>
          <!-- 게시글 제목 및 하이퍼링크 -->
          <td class="align-left">
            <a href="View.jsp?num=<%= board.getNum() %>"><%= board.getTitle() %></a>
          </td>
          <!-- 작성자 아이디 -->
          <td class="align-center">
            <%= board.getId() %>
          </td>
          <!-- 조회수 -->
          <td class="align-center">
            <%= board.getVisitcount() %>
          </td>
          <!-- 작성일 -->
          <td class="align-center">
            <%= board.getPostdate() %>
          </td>
        </tr>
    <%
        }
      }
    %>
  </table>

  <!-- 글쓰기 버튼 -->
  <table>
    <tr class="align-right">
      <td>
        <!-- location.href="이동할 주소"; -->
        <button type="button" onclick="location.href='Write.jsp';">
          글쓰기
        </button>
      </td>
    </tr>
  </table>


</body>
</html>
