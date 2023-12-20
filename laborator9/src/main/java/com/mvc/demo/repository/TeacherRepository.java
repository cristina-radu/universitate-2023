package com.mvc.demo.repository;

import com.mvc.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByCourses_Name(String courseName);
}
