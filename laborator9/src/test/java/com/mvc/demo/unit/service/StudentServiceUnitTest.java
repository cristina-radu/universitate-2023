package com.mvc.demo.unit.service;

import com.mvc.demo.dto.StudentDto;
import com.mvc.demo.exception.EntityNotFoundException;
import com.mvc.demo.mapper.StudentMapper;
import com.mvc.demo.model.Student;
import com.mvc.demo.repository.StudentRepository;
import com.mvc.demo.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

public class StudentServiceUnitTest {
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;
    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById_success(){
        Student student = getDummyStudent();
        StudentDto studentDto = getDummyStudentDto();
        Mockito.when(studentRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(student));
        Mockito.when(studentMapper.map(student))
                .thenReturn(studentDto);

        StudentDto returnedStudent = studentService.getById(10l);

        Assertions.assertEquals(returnedStudent.getFirstName(), studentDto.getFirstName());
        Assertions.assertEquals(returnedStudent.getLastName(), studentDto.getLastName());
        Assertions.assertEquals(returnedStudent.getAge(), studentDto.getAge());
        Assertions.assertEquals(returnedStudent.getScore(), studentDto.getScore());
    }

    @Test
    public void testGetById_exception(){
        Mockito.when(studentRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> studentService.getById(10l));
    }

    private Student getDummyStudent(){
        Student student = new Student();
        student.setId(10l);
        student.setFirstName("Mircea");
        student.setLastName("Pop");
        student.setAge(22);
        student.setScore(9);
        return student;
    }

    private StudentDto getDummyStudentDto(){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(10l);
        studentDto.setFirstName("Mircea");
        studentDto.setLastName("Pop");
        studentDto.setAge(22);
        studentDto.setScore(9);
        return studentDto;
    }
}
