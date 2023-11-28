package service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Scope("prototype")
@Component
public class MathService {
    private static int noOfInstances = 0;

    @PostConstruct
    private void setUp(){
        noOfInstances ++;
        System.out.println("Instance number: "+ noOfInstances);
    }

    public int sum(int no1, int no2) {
        return no1 + no2;
    }
}
