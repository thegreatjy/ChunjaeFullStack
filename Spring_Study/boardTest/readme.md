# Spring 게시판 연습 프로젝트

# 기술 스택
java jdk 11
mariadb
mybatis
spring
jquery ajax

# 코드 설명
https://jygrace.tistory.com/129

# 글 목록 페이징

1. 페이징 객체 생성

```java
@Getter
@Setter
@ToString
public class PageDTO {
    private int page; // 현재 페이지
    private int maxPage; // 전체 필요한 페이지 갯수
    private int startPage; // 현재 페이지 기준 시작 페이지 값
    private int endPage; // 현재 페이지 기준 마지막 페이지 값
}
```

1. 컨트롤러 요청명의 쿼리 스트링으로 현재 페이지 번호인 page를 전달한다.
- @RequestParam(value="page", required=false, defaultValue = "1") int page
- 현재 페이지에 해당하는 글만 불러온다. model에 담아 전달한다.
- 현재 페이지에 맞는 하단 페이징을 계산한다. model에 담아 전달한다.

```java
// /board/paging?page=2
@GetMapping("/paging")
public String paging(Model model, @RequestParam(value="page", required=false, defaultValue = "1") int page){
    log.info("page : "+page);
    // 해당 페이지에 보여줄 글 목록
    List<BoardDTO> pagingList = boardService.pageList(page);
    log.info(pagingList);

    // 해당 페이지 하단의 페이징
    PageDTO pageDTO = boardService.pagingParam(page);
    model.addAttribute("boardList", pagingList);
    model.addAttribute("paging", pageDTO);

    return "paging";
}
```

1. 현재 페이지에 해당하는 글만 불러온다.
- offset : sql 쿼리문 결과가 어디서부터 시작할지. (현재 페이지 - 1) * 한 페이지 당 글 개수
- limit : 몇 개의 게시글을 가져올지

```java
// service

int pageLimit = 3; // 한 페이지당 보여줄 글 갯수
int blockLimit = 3; // 하단에 보여줄 페이지 번호 갯수 << 1 2 3 >>

public List<BoardDTO> pageList(int page) {
    /*
    1페이지당 보여지는 글 갯수 3
    1page => 0 2page => 3 3page => 6
    */
    int pagingStart = (page - 1) * pageLimit;

    Map<String, Integer> pagingParams = new HashMap<>();
    pagingParams.put("offset", pagingStart);
    pagingParams.put("limit", pageLimit);

    // 현재 페이지인 page에 출력될 게시글 리스트
    List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
    return pagingList;
}
```

```sql
// mapper.xml

<select id="pagingList" parameterType="java.util.HashMap" resultType="board">
    select * 
		from board_table 
		order by id desc 
		limit #{limit} 
		offset #{offset}
</select>
```

1. 하단 페이징 초기화
- 전체 글 개수를 구한다.
- 전체 페이지 개수 : (전체 글 개수 / 한 페이지 당 글 개수)의 올림
- 시작 페이지 : 현재 페이지 기준 시작 페이지.
    - (((현재 페이지 / 하단에 보여지는 페이지 개수)의 올림 - 1) * 하단에 보여지는 페이지 개수) + 1
- 끝 페이지 : 시작 페이지 + 하단에 보여지는 페이지 개수 - 1.
    - 전체 페이지 개수보다 클 경우 전체 페이지 수가 끝 페이지

```java
public PageDTO pagingParam(int page){
    // 전체 글 개수 조회
    int boardCount = boardRepository.boardCount();
    // 전체 페이지 개수 계산 (전체 글 개수/한 페이지당 글 개수의 올림, 10/3 = 4)
    int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
    // 시작 페이지 값 (현재 페이지에서 맨 위 게시글 번호) 계산
    int startPage = ((int)(Math.ceil((double)page/blockLimit)) - 1) * blockLimit + 1;
    // 끝 페이지 값 (현재 페이지에서 맨 아래 게시글 번호) 계산
    int endPage = startPage + blockLimit - 1;

    if(endPage > maxPage){
        endPage = maxPage;
    }
    PageDTO pageDTO = new PageDTO();
    pageDTO.setPage(page);
    pageDTO.setMaxPage(maxPage);
    pageDTO.setStartPage(startPage);
    pageDTO.setEndPage(endPage);
    return pageDTO;
}
```

1. 뷰

```html
<div>
    <!-- [이전] -->
    <c:choose>
        <%-- 현재 페이지가 1페이지면 이전 글자만 보여줌 --%>
        <c:when test="${paging.page<=1}">
            <span>[이전]</span>
        </c:when>
        <%-- 1페이지가 아닌 경우에는 [이전]을 클릭하면 현재 페이지보다 1 작은 페이지 요청 --%>
        <c:otherwise>
            <a href="/board/paging?page=${paging.page-1}">[이전]</a>
        </c:otherwise>
    </c:choose>

    <%--  for(int i=startPage; i<=endPage; i++)      --%>
    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
        <c:choose>
            <%-- 요청한 페이지에 있는 경우 현재 페이지 번호는 텍스트만 보이게 --%>
            <c:when test="${i == paging.page}">
                <span>${i}</span>
            </c:when>

            <c:otherwise>
                <a href="/board/paging?page=${i}">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:choose>
        <c:when test="${paging.page>=paging.maxPage}">
            <span>[다음]</span>
        </c:when>
        <c:otherwise>
            <a href="/board/paging?page=${paging.page+1}">[다음]</a>
        </c:otherwise>
    </c:choose>
</div>
```

# 댓글 ajax

1. 뷰 - html

```html
<!-- 댓글 -->
<div>
    <!-- 댓글 작성 영역 -->
    <input type="text" id="commentWriter" placeholder="작성자">
    <input type="text" id="commentContents" placeholder="내용">
    <button id="comment-write-btn" onclick="commentWrite()">댓글작성</button>
    
		<!-- 댓글 목록 -->
    <div id = "comment-list">
        <table>
            <tr>
                <th>댓글번호</th>
                <th>작성자</th>
                <th>내용</th>
                <th>작성시간</th>
            </tr>
            <c:forEach items="${commentList}" var="comment">
                <tr>
                    <td>${comment.id}</td>
                    <td>${comment.commentWriter}</td>
                    <td>${comment.commentContents}</td>
                    <td>${comment.commentCreatedTime}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
```

1. 뷰 - script ajax
- 댓글 작성 버튼을 누르면 자바 스크립트 함수 실행
- type : http 메서드
- url : 요청주소
- data : 요청 시, 전달할 데이터
- dataType : 응답 받을 때, 데이터 타입
- 응답받은 댓글 데이터로 html을 만들고, document.getElementById('comment-list').innerHTML로 대체한다.

```javascript
// 댓글 등록
    const commentWrite = () => {
        const writer = document.getElementById("commentWriter").value;
        const contents = document.getElementById("commentContents").value;
        const board = '${board.id}';

        $.ajax({
            type: "post",
            url: "/comment/save",
            data: {
                commentWriter: writer,
                commentContents: contents,
                boardId: board
            },
            dataType: "json",
            success: function(commentList) {
                console.log("작성 성공");
                console.log(commentList);

                let output = "<table>";
                output += "<tr><th>댓글번호</th>";
                output += "<th>작성자</th>";
                output += "<th>내용</th>";
                output += "<th>작성시간</th></tr>";
                for(let i in commentList){
                    output += "<tr>";
                    output += "<td>"+commentList[i].id+"</td>";
                    output += "<td>"+commentList[i].commentWriter+"</td>";
                    output += "<td>"+commentList[i].commentContents+"</td>";
                    output += "<td>"+commentList[i].commentCreatedTime+"</td>";
                    output += "</tr>";
                }
                output += "</table>";

                document.getElementById('comment-list').innerHTML = output;
                document.getElementById('commentWriter').value='';
                document.getElementById('commentContents').value='';
            },
            error: function() {
                console.log("실패");
            }
        });
```

1. controller
- @ResponseBody List<CommentDTO> : CommentDTO 리스트 객체를 반환한다.
- @ResponseBody : return 자바 객체를 하면 json 객체로 변환하여 전달된다.

```java
@PostMapping("/save")
    public @ResponseBody List<CommentDTO> save(@ModelAttribute CommentDTO commentDTO){
        // @ResponseBody : return 자바 객체를 하면 json 객체로 변환하여 전달된다.
        System.out.print("commentDTO:"+commentDTO);
        commentService.save(commentDTO);      /// 댓글 insert

        // 헤당 게시글의 댓글 목록을 조회
        List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId());
        return commentDTOList;
    }
```