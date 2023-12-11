package com.mvc.demo.controller;


import com.mvc.demo.model.Student;
import com.mvc.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("data", studentService.getAll());
        model.addAttribute("student", new Student());
        return "home";
    }
}
