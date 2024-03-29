package kr.co.chunjae.repository;

import kr.co.chunjae.domain.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSessionTemplate sql;

    public int login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login", memberDTO);
    }
}
