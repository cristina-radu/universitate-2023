package com.mvc.demo.controller;

import com.mvc.demo.dto.CourseDto;
import com.mvc.demo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDto> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/id/{id}")
    public CourseDto getCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }

    @PostMapping()
    public CourseDto saveCourse(@RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto);
    }
}
