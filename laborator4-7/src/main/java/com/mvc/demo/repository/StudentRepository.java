package com.mvc.demo.repository;

import com.mvc.demo.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    @PostConstruct
    private void setUp() {
        students.add(new Student(1, "Ana", "Popescu", 21, 9));
        students.add(new Student(2, "Bogdan", "Dragomir", 23, 8));
        students.add(new Student(3, "Maria", "Pop", 22, 9));
        students.add(new Student(4, "Marian", "Luca", 22, 9));
    }

    public List<Student> getAll(){
        return students;
    }

    public void add(Student student){
        students.add(student);
    }

    public void update(String firstName, Student newStudent){
        students.forEach(dbStudent -> {
            if(dbStudent.getFirstName().equals(firstName)) {
                if(newStudent.getFirstName() != null){
                    dbStudent.setFirstName(newStudent.getFirstName());
                }
                if(newStudent.getLastName() != null){
                    dbStudent.setLastName(newStudent.getLastName());
                }
                if(newStudent.getAge() != null){
                    dbStudent.setAge(newStudent.getAge());
                }
            }
        });
    }

    public void updateWithPut(Integer id, Student newStudent){
        students.forEach(student -> {
            if(student.getId() == id){
                student.setAge(newStudent.getAge());
                student.setFirstName(newStudent.getFirstName());
                student.setLastName(newStudent.getLastName());
                student.setScore(newStudent.getScore());
            }
        });
    }

    public void updateWithPatch(Integer id, Student newStudent){
        students.forEach(student -> {
            if(student.getId() == id){
                if(newStudent.getFirstName() != null) {
                    student.setFirstName(newStudent.getFirstName());
                }
                if(newStudent.getLastName() != null) {
                    student.setLastName(newStudent.getLastName());
                }
                if(newStudent.getAge() != null) {
                    student.setAge(newStudent.getAge());
                }
                if(newStudent.getScore() != null) {
                    student.setScore(newStudent.getScore());
                }
            }
        });
    }

    public void delete(String firstName) {
        List<Student> newList = new ArrayList<>();
        students.forEach(elem -> {
            if(!elem.getFirstName().equals(firstName)) {
                newList.add(elem);
            }
        });
        students = newList;
    }

    public List<Student> getStudentsByAge(Integer age){
        return students.stream().filter(student -> student.getAge() == age).toList();
    }

    public List<Student> getStudentsByAgeAndScore(Integer age, Integer score){
        return students.stream()
                .filter(student -> student.getAge() == age && student.getScore() == score)
                .toList();
    }

    public Student getById(Integer id){
        List<Student> student = students.stream().filter(elem -> elem.getId() == id).collect(Collectors.toList());
        if(student.size() == 0){
            throw new RuntimeException("No student with id: "+ id);
        }
        return student.get(0);
    }
}
