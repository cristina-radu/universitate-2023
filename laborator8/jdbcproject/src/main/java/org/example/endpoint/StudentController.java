package org.example.endpoint;

import org.example.model.Student;
import org.example.service.JdbcService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private JdbcService jdbcService;

    public StudentController(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return jdbcService.findStudents();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return jdbcService.executeProcedure(student);
    }
}
