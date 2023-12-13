package com.mvc.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_course_catalog")
public class StudentCourseCatalog {
    @EmbeddedId
    private StudentCourseCatalogKey studentCourseCatalogKey;

    private Integer score;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn( name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn( name = "course_id")
    private Course course;
}
