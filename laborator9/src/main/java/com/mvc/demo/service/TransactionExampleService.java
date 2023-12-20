package com.mvc.demo.service;

import com.mvc.demo.exception.EntityAlreadyExistsException;
import com.mvc.demo.exception.EntityNotFoundException;
import com.mvc.demo.model.Course;
import com.mvc.demo.model.Teacher;
import com.mvc.demo.repository.CourseRepository;
import com.mvc.demo.repository.StudentRepository;
import com.mvc.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class TransactionExampleService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public TransactionExampleService(CourseRepository courseRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional(rollbackFor = { EntityAlreadyExistsException.class })
    public void bulkOperations(){
        String courseName = "Spanish";
        Course spanishCourse = new Course();
        spanishCourse.setName(courseName);
        Course dbSpanishCourse = courseRepository.save(spanishCourse);

        if(courseName.equals("Spanish")){
            throw new EntityAlreadyExistsException("Course Name already exists in db.");
        }

        /*Course course = new Course();
        course.setName("Spanish");
        Course dbCourse = courseRepository.save(spanishCourse);*/


        Teacher teacher = new Teacher();
        teacher.setFirstName("Madalina");
        teacher.setLastName("Manole");
        teacherRepository.save(teacher);
    }
}
