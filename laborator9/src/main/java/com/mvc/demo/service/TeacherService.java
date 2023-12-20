package com.mvc.demo.service;

import com.mvc.demo.dto.TeacherDto;
import com.mvc.demo.exception.EntityNotFoundException;
import com.mvc.demo.mapper.TeacherMapper;
import com.mvc.demo.model.Course;
import com.mvc.demo.model.Teacher;
import com.mvc.demo.repository.CourseRepository;
import com.mvc.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final TeacherMapper teacherMapper;

    public TeacherService(TeacherRepository teacherRepository, CourseRepository courseRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
        this.courseRepository = courseRepository;
    }

    public List<TeacherDto> getAllTeachers(){
        List<Teacher> teachers = teacherRepository.findAll();
        return teacherMapper.mapListToTeacherDto(teachers);
    }

    public TeacherDto getTeacher(Long id){
        Teacher teacher = teacherRepository.findById(id)
                .orElseGet(() -> {throw new EntityNotFoundException("Teacher with id "+ id + " doesn't exist in the db.");});
        return teacherMapper.map(teacher);
    }

    public TeacherDto getTeacherForCourseName(String courseName){
        Teacher teacher = teacherRepository.findByCourses_Name(courseName);
        return teacherMapper.map(teacher);
    }

    public TeacherDto saveTeacher(TeacherDto teacherDto){
        Teacher dbTeacher =  teacherRepository.save(teacherMapper.map(teacherDto));
        return teacherMapper.map(dbTeacher);
    }

    public TeacherDto addCourseToTeacher(Long teacherId, Long courseId) {
        Teacher dbTeacher = teacherRepository.findById(teacherId).orElseGet(() -> {throw new EntityNotFoundException("Teacher with id "+ courseId
                + " not found in db.");});
        Course dbCourse = courseRepository.findById(courseId).orElseGet(() -> {throw new EntityNotFoundException("Teacher with id "+ courseId
                + " not found in db.");});
        dbTeacher.getCourses().add(dbCourse);
        return teacherMapper.map(teacherRepository.save(dbTeacher));
    }
}
