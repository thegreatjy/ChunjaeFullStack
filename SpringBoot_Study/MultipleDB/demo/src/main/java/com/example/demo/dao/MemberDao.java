package com.example.demo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MemberDao {
    @Autowired
    @Resource(name="memberSqlSessionTemplate")
    private SqlSession memberSqlSession;
    // 싱글톤 패턴으로 생성해준다.

    public MemberDao(SqlSession memberSqlSession) {
        this.memberSqlSession = memberSqlSession;
    }

    public List list(){
        // id: namespace.id
        return memberSqlSession.selectList("member.list");
    }
}
