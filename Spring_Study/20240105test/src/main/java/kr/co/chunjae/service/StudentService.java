package kr.co.chunjae.service;

import kr.co.chunjae.domain.StudentDTO;
import kr.co.chunjae.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<StudentDTO> selectAll() {
        return studentRepository.selectAll();
    }

    public boolean insert(StudentDTO studentDTO) {
        int result = studentRepository.insert(studentDTO);
        if (result == 1) {
            return true;
        }else{
            return false;
        }
    }

    public StudentDTO selectByStudentId(int studentId) {
        StudentDTO studentDTO = studentRepository.selectByStudentId(studentId);
        return studentDTO;
    }

    public void update(StudentDTO studentDTO) {
        studentRepository.update(studentDTO);
    }

    public void delete(int studentId) {
        studentRepository.delete(studentId);
    }
}
