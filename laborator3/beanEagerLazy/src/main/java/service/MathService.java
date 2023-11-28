package service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Lazy
@Component
public class MathService {

    @PostConstruct
    private void setUp(){
        System.out.println("Created Instance of class MathService.");
    }

    public int sum(int no1, int no2) {
        return no1 + no2;
    }
}
