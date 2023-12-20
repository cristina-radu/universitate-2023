package com.mvc.demo.mapper;

import com.mvc.demo.model.Student;
import com.mvc.demo.dto.StudentDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    private AddressMapper addressMapper;
    private CourseMapper courseMapper;

    public StudentMapper(AddressMapper addressMapper, CourseMapper courseMapper) {
        this.addressMapper = addressMapper;
        this.courseMapper = courseMapper;
    }

    public List<StudentDto> mapListToStudentDto(List<Student> students){
        return students.stream().map(student -> map(student)).collect(Collectors.toList());
    }

    public List<Student> mapListToStudent(List<StudentDto> studentDtos){
        return studentDtos.stream().map(studentDto -> map(studentDto)).collect(Collectors.toList());
    }

    public Student map(StudentDto studentDto){
        if(studentDto == null){
            return null;
        }
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setAge(studentDto.getAge());
        student.setScore(studentDto.getScore());
        student.setAddress(addressMapper.map(studentDto.getAddress()));
        student.setCourses(courseMapper.mapListToCourse(studentDto.getCourses()));
        return student;
    }

    public StudentDto map(Student student){
        if(student == null){
            return null;
        }
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setAge(student.getAge());
        studentDto.setScore(student.getScore());
        studentDto.setAddress(addressMapper.map(student.getAddress()));
        studentDto.setCourses(courseMapper.mapListToCourseDto(student.getCourses()));
        return studentDto;
    }
}
