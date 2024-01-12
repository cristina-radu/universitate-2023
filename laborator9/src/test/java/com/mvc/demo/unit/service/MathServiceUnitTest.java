package com.mvc.demo.unit.service;

import com.mvc.demo.service.MathService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathServiceUnitTest {
    private MathService mathService = new MathService();

    @Test
    public void testAdd_success(){
        Assertions.assertEquals(4, mathService.add(2, 2));
    }

    @Test
    public void testMultiply_success() {
        Assertions.assertEquals(6, mathService.multiply(2, 3));
    }
}
