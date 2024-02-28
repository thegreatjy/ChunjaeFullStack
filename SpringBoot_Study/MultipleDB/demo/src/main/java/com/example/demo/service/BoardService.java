package com.example.demo.service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dao.MemberDao;
import com.example.demo.vo.QnaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardService {
    // tx는 서비스 단에 걸어야 한다.

    @Autowired
    private BoardDao boardDao;

    @Autowired
    private MemberDao memberDao;

    public HashMap list(){
        HashMap result = new HashMap<>();

        result.put("board", boardDao.list());
        result.put("member", memberDao.list());

        return result;
    }

    public HashMap write() {
        QnaVo qnaVo = new QnaVo("titleTemp", "userIdTemp");
        int id = boardDao.write(qnaVo);

        HashMap result = new HashMap();
        result.put("id", id);
        return result;
    }
}
