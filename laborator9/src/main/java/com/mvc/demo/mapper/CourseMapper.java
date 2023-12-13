package com.mvc.demo.mapper;

import com.mvc.demo.dto.CourseDto;
import com.mvc.demo.dto.StudentDto;
import com.mvc.demo.model.Course;
import com.mvc.demo.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public List<CourseDto> mapListToCourseDto(List<Course> courses){
        return courses.stream().map(course -> map(course)).collect(Collectors.toList());
    }

    public List<Course> mapListToCourse(List<CourseDto> courseDtos){
        return courseDtos.stream().map(courseDto -> map(courseDto)).collect(Collectors.toList());
    }
    public Course map(CourseDto courseDto){
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setName(courseDto.getName());
        return course;
    }

    public CourseDto map(Course course){
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        return courseDto;
    }

}
