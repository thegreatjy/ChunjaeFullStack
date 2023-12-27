package kr.co.chunjae.repository;

import kr.co.chunjae.dto.MemberDTO;
import kr.co.chunjae.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final SqlSessionTemplate sql;

    public int insert(StudentDTO studentDTO) {
        return sql.insert("Student.insert", studentDTO);
    }

    public int update(StudentDTO studentDTO) {
        return sql.update("Student.update", studentDTO);
    }

    public ArrayList<StudentDTO> selectAll() {
        List<StudentDTO> qList = sql.selectList("Student.selectAll");
        ArrayList<StudentDTO> arrayList = new ArrayList<StudentDTO>();
        arrayList.addAll(qList);
        for(int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i).getStudentName());
        }
        return arrayList;
    }

    public StudentDTO select(int intId) {
        return sql.selectOne("Student.select", intId);
    }

    public void delete(int intId) {
        sql.delete("Student.delete", intId);
    }

    public StudentDTO searchById(int intId) {
        return sql.selectOne("Student.searchById", intId);
    }
}
