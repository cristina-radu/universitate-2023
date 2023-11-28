package com.project.demo.xml_config.service;

import com.project.demo.xml_config.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void justDoIt(){
        System.out.println("Just do it!");
    }

    public void getStudent(){
        studentRepository.getStudent();
    }
}
