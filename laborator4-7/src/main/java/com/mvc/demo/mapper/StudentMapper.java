package com.mvc.demo.mapper;

import com.mvc.demo.model.Student;
import com.mvc.demo.request.StudentRequest;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student map(StudentRequest studentRequest){
        Student student = new Student();
        student.setId(studentRequest.getId());
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setAge(studentRequest.getAge());
        student.setScore(studentRequest.getScore());
        return student;
    }
}
