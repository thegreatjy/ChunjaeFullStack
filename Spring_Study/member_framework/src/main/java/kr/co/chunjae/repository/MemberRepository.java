package kr.co.chunjae.repository;

import kr.co.chunjae.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Log4j2
public class MemberRepository {
    private final SqlSessionTemplate sql;

    public int save(MemberDTO memberDTO){
        System.out.println("memberDTO : " + memberDTO);
        // statement: mapper_namespace.id (철자 주의) / Object: parameterType
        int saveResult = sql.insert("Member.save", memberDTO);
        log.info(memberDTO);
        return saveResult;
    }

    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login", memberDTO);
    }

    public List<MemberDTO> findAll(){
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById", id);
    }
}
