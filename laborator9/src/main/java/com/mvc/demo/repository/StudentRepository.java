package com.mvc.demo.repository;

import com.mvc.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByAgeGreaterThanEqual(Integer age);

    List<Student> findAllByAddress_Street(String street);

    @Query(" from Student where score=:score")
    List<Student> findStudentsWithScore(Integer score);

    @Modifying
    @Query(nativeQuery = true, value = "select * from student where age = :age or score = :score")
    List<Student> findStudentsWithAgeOrWithScore(Integer age, Integer score);
}
