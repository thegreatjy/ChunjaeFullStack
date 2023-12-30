package kr.co.chunjae.repository;

import kr.co.chunjae.domain.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSessionTemplate sql;


    public int save(MemberDTO memberDTO) {
        return sql.insert("Member.save", memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        MemberDTO result = (MemberDTO)sql.selectOne("Member.login", memberDTO);
        return result;
    }

    public int searchEmail(String email) {
        int result = sql.selectOne("Member.searchEmail", email);
        return result;
    }

    public List<MemberDTO> findAll() {
        List<MemberDTO> memberDTOList = sql.selectList("Member.findAll");
        return memberDTOList;
    }

    public MemberDTO findById(int id) {
        MemberDTO memberDTO = sql.selectOne("Member.findById", id);
        return memberDTO;
    }

    public void delete(int id) {
        sql.delete("Member.delete", id);
    }

    public MemberDTO findByEmail(String email) {
        return sql.selectOne("Member.findByEmail", email);
    }

    public int update(MemberDTO memberDTO) {
        return sql.update("Member.update", memberDTO);
    }
}
