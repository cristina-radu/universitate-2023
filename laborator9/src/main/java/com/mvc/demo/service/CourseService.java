package com.mvc.demo.service;

import com.mvc.demo.dto.CourseDto;
import com.mvc.demo.dto.TeacherDto;
import com.mvc.demo.exception.EntityNotFoundException;
import com.mvc.demo.mapper.CourseMapper;
import com.mvc.demo.model.Course;
import com.mvc.demo.model.Teacher;
import com.mvc.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<CourseDto> getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        return courseMapper.mapListToCourseDto(courses);
    }

    public CourseDto getCourse(Long id){
        Course course = courseRepository.findById(id)
                .orElseGet(() -> {throw new EntityNotFoundException("Teacher with id "+ id + " doesn't exist in the db.");});
        return courseMapper.map(course);
    }

    public CourseDto saveCourse(CourseDto courseDto){
        Course dbCourse =  courseRepository.save(courseMapper.map(courseDto));
        return courseMapper.map(dbCourse);
    }
}
