package com.mvc.demo.mapper;


import com.mvc.demo.dto.TeacherDto;
import com.mvc.demo.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherMapper {
    private final CourseMapper courseMapper;

    public TeacherMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public List<TeacherDto> mapListToTeacherDto(List<Teacher> students){
        return students.stream().map(student -> map(student)).collect(Collectors.toList());
    }

    public List<Teacher> mapListToTeacher(List<TeacherDto> teacherDtos){
        return teacherDtos.stream().map(teacherDto -> map(teacherDto)).collect(Collectors.toList());
    }

    public Teacher map(TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        teacher.setId(teacherDto.getId());
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setCourses(courseMapper.mapListToCourse(teacherDto.getCourses()));
        return teacher;
    }

    public TeacherDto map(Teacher teacher){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setFirstName(teacher.getFirstName());
        teacherDto.setLastName(teacher.getLastName());
        teacherDto.setCourses(courseMapper.mapListToCourseDto(teacher.getCourses()));
        return teacherDto;
    }
}
