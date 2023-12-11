package com.mvc.demo.repository;

import com.mvc.demo.exception.StudentAlreadyExistsException;
import com.mvc.demo.exception.StudentNotFoundException;
import com.mvc.demo.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findAllByAgeGreaterThanEqual(Integer age);
}
