package service;

import org.springframework.stereotype.Component;

import java.sql.SQLOutput;


@Component
public class MathService {

    public int sum(int no1, int no2) {
        System.out.println(no1 + no2);
        throw new RuntimeException("Error");
    }

    public int multiply(int no1, int no2){
        System.out.println(no1 * no2);
        return no1 * no2;
    }
}
