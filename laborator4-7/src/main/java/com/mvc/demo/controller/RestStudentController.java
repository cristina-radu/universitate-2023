package com.mvc.demo.controller;

import com.mvc.demo.model.Student;
import com.mvc.demo.service.StudentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("rest-student")
@RestController
public class RestStudentController {
    private StudentService studentService;

    public RestStudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id) {
        Student student=null;
        try {
           studentService.getById(id);
        } catch (RuntimeException ex){
            new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/with-custom-header/id/{id}")
    public ResponseEntity<Student> getWithCustomHeader(@PathVariable Integer id) {
        Student student=null;
        try {
            studentService.getById(id);
        } catch (RuntimeException ex){
            new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("my_header", "my test header");
        return new ResponseEntity<>(student, headers, HttpStatus.OK);
    }

    @PostMapping
    public void add(@RequestBody Student student) {
        studentService.add(student);
    }

    @PutMapping("/{id}")
    public void updateWithPut(@PathVariable Integer id, @RequestBody Student student) {
        studentService.updateWithPut(id, student);
    }

    @PatchMapping("/{id}")
    public void updateWithPatch(@PathVariable Integer id, @RequestBody Student student) {
        studentService.updateWithPatch(id, student);
    }

    @GetMapping("/age/{age}")
    public List<Student> getAllStudentsByAge(@PathVariable Integer age) {
        return studentService.getStudentsByAge(age);
    }

     @GetMapping("/age")
     public List<Student> getAllStudentsByAgeParam(@RequestParam Integer age) {
        return studentService.getStudentsByAge(age);
     }

    @GetMapping("/{age}/{score}")
    public List<Student> getAllStudentsByAgeAndScore(@PathVariable Integer age, @PathVariable Integer score) {
        return studentService.getStudentsByAgeAndScore(age, score);
    }

    @GetMapping("age-score")
    public List<Student> getAllStudentsByAgeAndScoreReqParam(@RequestParam Integer age, @RequestParam Integer score){
        return studentService.getStudentsByAgeAndScore(age, score);
    }

    @DeleteMapping("/{firstName}")
    public void delete(@PathVariable String firstName) {
        studentService.delete(firstName);
    }
}
