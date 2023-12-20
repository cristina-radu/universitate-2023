package com.mvc.demo.controller;

import com.mvc.demo.dto.StudentDto;
import com.mvc.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/id/{id}")
    public StudentDto getById(@PathVariable Long id) {
       return studentService.getById(id);
    }

    @PostMapping
    public StudentDto save(@RequestBody @Valid StudentDto studentDto) {
       return studentService.save(studentDto);
    }

    @GetMapping("/age/{age}")
    public List<StudentDto> getAllStudentsByAgeOrGreaterThan(@PathVariable Integer age) {
        return studentService.getStudentsByAgeOrGreaterThan(age);
    }

    @GetMapping("/score/{score}")
    public List<StudentDto> getAllStudentsByScore(@PathVariable Integer score) {
        return studentService.getStudentsWithScore(score);
    }

    @GetMapping("/address/street/{streetName}")
    public List<StudentDto> getAllStudentsByAddressStreet(@PathVariable String streetName) {
        return studentService.getStudentsWithAddressStreetName(streetName);
    }

    @GetMapping("/age/{age}/score/{score}")
    public List<StudentDto> findStudentsWithAgeOrWithScore(@PathVariable Integer age, @PathVariable Integer score) {
        return studentService.getStudentsWithAgeOrWithScore(age, score);
    }

/*
    @PutMapping("/{id}")
    public void updateWithPut(@PathVariable Integer id, @RequestBody Student student) {
        studentService.updateWithPut(id, student);
    }

    @PatchMapping("/{id}")
    public void updateWithPatch(@PathVariable Integer id, @RequestBody Student student) {
        studentService.updateWithPatch(id, student);
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
*/
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
