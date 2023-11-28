package com.project.demo.bean_annotation_config.configuration;

import com.project.demo.bean_annotation_config.service.CourseService;
import com.project.demo.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public CourseService courseService(){
        return new CourseService();
    }

    @Primary
    @Bean(name = "bradPitt")
    public Student bradPitt(){
        return new Student("Brad", "Pitt");
    }

    @Bean(name = "leonardoDiCaprio")
    public Student leonardoDiCaprio(){
        return new Student("Leonardo", "DiCaprio");
    }

    @Bean
    public List<Student> enrolledStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Brad", "Pitt"));
        students.add(new Student("Leonardo", "DiCaprio"));
        students.add(new Student("Margot", "Robbi"));
        return students;
    }
}
