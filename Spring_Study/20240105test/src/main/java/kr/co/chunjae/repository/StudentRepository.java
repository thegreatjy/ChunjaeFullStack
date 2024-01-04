package kr.co.chunjae.repository;

import kr.co.chunjae.domain.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final SqlSessionTemplate sql;

    public List<StudentDTO> selectAll() {
        return sql.selectList("Student.selectAll");
    }

    public int insert(StudentDTO studentDTO) {
        return sql.insert("Student.insert", studentDTO);
    }

    public StudentDTO selectByStudentId(int studentId) {
        return sql.selectOne("Student.selectByStudentId", studentId);
    }

    public void update(StudentDTO studentDTO) {
        sql.update("Student.update", studentDTO);
    }

    public void delete(int studentId) {
        sql.delete("Student.delete", studentId);
    }
}
