<%@ page import="model1.board.BoardDAO" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="model1.board.BoardDTO" %>
<%@ page import="utils.BoardPage"%>
<%@ page import="java.util.List" %>
<%--
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

  // page 처리
  // 전체 페이지 수 계산
  int pageSize = Integer.parseInt(application.getInitParameter("posts_per_page")); // 1페이지 당 10개 게시물
  int blockPage = Integer.parseInt(application.getInitParameter("pages_per_block")); // 게시판 5 페이지
  int totalPage = (int)Math.ceil((double)totalCount/pageSize); // 전체 게시물 수/10 + 1 = 총 페이지 수

  // 전체 페이지 확인
  int pageNum = 1; // 기본값
  String pageTemp = request.getParameter("pageNum");  // 요청받은 페이지 번호
  if (pageTemp != null && !pageTemp.equals("")) { // null 혹은 빈 문자열인지 확인
    pageNum = Integer.parseInt(pageTemp);
  }

  // 목록에 출력할 게시물 범위 계산
  int start = totalCount - ((pageNum - 1) * pageSize); // 첫 게시물 번호
  param.put("start", start); // 첫 게시물 번호
  param.put("totalCount", totalCount); // 총 게시물 갯수
  param.put("pageSize", pageSize); // 총 게시물 갯수
  // page 처리

  // 검색 결과 (게시글)
  System.out.println("=====");

  List<BoardDTO> boardList = dao.selectListPage(param);
  System.out.println(" ===== ");
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
      align: center;
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

  <h2>목록 보기(List) - 현재 페이지 : <%= pageNum %> (전체 : <%= totalPage %>)</h2>
  <!-- 검색 입력폼 -->
  <form method="get">
    <table>
      <tr>
        <td class="align-center">
          <!-- 검색 종류 옵션 선택 (제목, 내용) -->
          <select name="searchField">
            <option value="title">제목</option>
            <option value="content">내용</option>
          </select>
          <input type="text" name="searchWord" />
          <input type="submit" name="검색하기" />
        </td>
      </tr>
    </table>
  </form>


  <!-- 게시물 목록 테이블 -->
  <table>
    <!-- 컬럼의 이름 -->
    <tr>
      <td class="width10" class="align-center">번호</td>
      <td class="width10" class="align-center">제목</td>
      <td class="width15" class="align-center">작성자</td>
      <td class="width10" class="align-center">조회수</td>
      <td class="width15" class="align-center">작성일</td>
    </tr>
    <!-- 목록 내용 -->
    <%
      // 게시글 목록에 등록된 게시글이 아무것도 없을 때
      if(boardList.isEmpty()){
    %>
      <tr>
        <td colspan="5" class="align-center">
          등록된 게시글이 없습니다.
        </td>
      </tr>
    <%
      // 게시글 목록에 글이 있을 때
      }else{
        int virtualNum = 0; // 화면상에서의 게시글 번호. 임의로 0으로 초기화
        int countNum = 0;
        for(BoardDTO board: boardList){
          // virtualNumber = totalCount--;  // 전체 게시물 수에서 시작해 1씩 감소
          virtualNum = totalCount - (((pageNum - 1) * pageSize) + countNum++);
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
    <tr class="align-center">
      <!-- 페이징 처리 -->
      <td>
        <%= BoardPage.pagingStr(totalCount, pageSize,
                blockPage, pageNum, request.getRequestURI()) %>
      </td>
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
