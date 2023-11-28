package com.project.demo.annotation_config.repository;

import org.springframework.stereotype.Component;

@Component
public class TeacherRepository {

    public void getBalance(){
        System.out.println("Teacher");
    }
}
