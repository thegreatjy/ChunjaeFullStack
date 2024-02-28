package com.example.demo.dao;

import com.example.demo.vo.QnaVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BoardDao {
    @Autowired
    @Resource(name="boardSqlSessionTemplate")
    private SqlSession boardSqlSession;
    // 싱글톤 패턴으로 생성해준다.

    public BoardDao(SqlSession boardSqlSession) {
        this.boardSqlSession = boardSqlSession;
    }

    public List list(){
        // id: namespace.id
        return boardSqlSession.selectList("board.list");
    }

    public int write(QnaVo qnaVo) {
        return boardSqlSession.insert("board.write", qnaVo);
    }
}
