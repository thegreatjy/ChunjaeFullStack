package kr.co.chunjae.service;

import kr.co.chunjae.dto.StudentDTO;
import kr.co.chunjae.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public boolean insert(StudentDTO studentDTO) {
        int insertResult = studentRepository.insert(studentDTO);
        if(insertResult == 1){
            return true;
        }else{
            return false;
        }
    }

    public boolean update(StudentDTO studentDTO) {
        int resultUpdate = studentRepository.update(studentDTO);
        if(resultUpdate == 1){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<StudentDTO> selectAll() {
        ArrayList<StudentDTO> studentList = studentRepository.selectAll();
        return studentList;
    }

    public StudentDTO select(int intId) {
        return studentRepository.select(intId);
    }

    public void delete(int intId) {
        studentRepository.delete(intId);
    }

    public StudentDTO searchById(int intId) {
        return studentRepository.searchById(intId);
    }
}
