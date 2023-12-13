package com.mvc.demo.service;

import com.mvc.demo.exception.StudentNotFoundException;
import com.mvc.demo.mapper.StudentMapper;
import com.mvc.demo.model.Student;
import com.mvc.demo.repository.StudentRepository;
import com.mvc.demo.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDto> getAll(){
        List<Student> allStudents = studentRepository.findAll();
        return studentMapper.mapListToStudentDto(allStudents);
    }

    public StudentDto save(StudentDto studentDto){
        Student dbStudent = studentRepository.save(studentMapper.map(studentDto));
        return studentMapper.map(dbStudent);
    }

 /*   public void updateWithPut(Integer id, Student student){
        studentRepository.updateWithPut(id, student);
    }

    public void updateWithPatch(Integer id, Student student){
        studentRepository.updateWithPatch(id, student);
    }
*/
    public void delete(Integer id){
        studentRepository.deleteById(id);
    }
/*
    public List<Student> getStudentsByAge(Integer age){
        return studentRepository.getStudentsByAge(age);
    }

    public List<Student> getStudentsByAgeAndScore(Integer age, Integer score){
        return studentRepository.getStudentsByAgeAndScore(age, score);
    }*/

    public StudentDto getById(Integer id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
  /*      return optionalStudent
                .orElseThrow(new StudentNotFoundException("Student with id: "+ id + " is not in the db."));
      */
        if(!optionalStudent.isPresent()){
            throw new StudentNotFoundException("Student with id: "+ id + " is not in the db.");
        }
        return studentMapper.map(optionalStudent.get());
    }

}
