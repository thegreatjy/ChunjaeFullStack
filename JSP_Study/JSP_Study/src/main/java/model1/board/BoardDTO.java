package model1.board;

import java.sql.Date;

public class BoardDTO {
    private String num;
    private String title;
    private String content;
    private String id; // 작성자 id. FK member(id)
    private java.sql.Date postdate;
    private String visitcount;  // 조회수
    private String name;    // 작성자 이름. member(name). join해서 얻어와야 함.
    // dto에는 다른 테이블의 컬럼을 멤버 변수로 추가할 수 있다.

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public String getVisitcount(){
        return visitcount;
    }

    public void setVisitcount(String visitcount){
        this.visitcount = visitcount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
