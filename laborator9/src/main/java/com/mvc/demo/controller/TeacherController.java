package com.mvc.demo.controller;

import com.mvc.demo.dto.CourseDto;
import com.mvc.demo.dto.TeacherDto;
import com.mvc.demo.service.TeacherService;
import com.mvc.demo.service.TransactionExampleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("teacher")
@RestController
public class TeacherController {
    private final TeacherService teacherService;

    private final TransactionExampleService transactionExampleService;

    public TeacherController(TeacherService teacherService, TransactionExampleService transactionExampleService) {
        this.teacherService = teacherService;
        this.transactionExampleService = transactionExampleService;
    }

    @GetMapping
    public List<TeacherDto> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/id/{id}")
    public TeacherDto getTeacher(@PathVariable Long id){
        return teacherService.getTeacher(id);
    }

    @PostMapping()
    public TeacherDto saveTeacher(@RequestBody TeacherDto teacherDto){
        return teacherService.saveTeacher(teacherDto);
    }

    @GetMapping("/add-course")
    public TeacherDto addCourseToTeacher(@RequestParam Long teacherId, @RequestParam Long courseId){
        return teacherService.addCourseToTeacher(teacherId, courseId);
    }

    @GetMapping("/course/{courseName}")
    public TeacherDto getCourse(@PathVariable String courseName) {
        return teacherService.getTeacherForCourseName(courseName);
    }

    @GetMapping("bulk-operation")
    public void bulkOperation(){
        transactionExampleService.bulkOperations();
    }
}
