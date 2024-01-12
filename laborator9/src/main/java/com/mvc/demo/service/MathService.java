package com.mvc.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public int add(int first, int second){
        return first + second;
    }

    public int multiply(int first, int second){
        return  first * second;
    }
}
