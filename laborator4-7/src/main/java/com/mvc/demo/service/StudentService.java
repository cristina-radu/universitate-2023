package com.mvc.demo.service;

import com.mvc.demo.model.Student;
import com.mvc.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll(){
        return studentRepository.getAll();
    }

    public void add(Student student){
        studentRepository.add(student);
    }

    public void updateWithPut(Integer id, Student student){
        studentRepository.updateWithPut(id, student);
    }

    public void updateWithPatch(Integer id, Student student){
        studentRepository.updateWithPatch(id, student);
    }

    public void delete(String firstName){
        studentRepository.delete(firstName);
    }

    public List<Student> getStudentsByAge(Integer age){
        return studentRepository.getStudentsByAge(age);
    }

    public List<Student> getStudentsByAgeAndScore(Integer age, Integer score){
        return studentRepository.getStudentsByAgeAndScore(age, score);
    }

    public Student getById(Integer id){
        return studentRepository.getById(id);
    }

}
