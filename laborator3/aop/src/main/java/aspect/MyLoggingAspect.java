package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@EnableAspectJAutoProxy
@Aspect
@Configuration
public class MyLoggingAspect {

    /*
    * jointpoint(locul de actiune al aspectului)
       point cut(expresie ce identifica locul de actiune)
        advice( before,after returning,after throwing,after,around)
*/

    @Pointcut("execution(public int service.MathService.sum(int, int))")
    public void mathServiceSumPointcut(){}

    @Pointcut("execution(* service.MathService.*(..))")
    public void mathServiceClassPointcut(){}

    @Before(value = "mathServiceSumPointcut()")
    public void loggingBeforeSum(){
        System.out.println("Before method SUM");
    }

    @AfterReturning(value = "mathServiceClassPointcut()", returning = "returnValue")
    public void loggingAfterReturningMathClass(JoinPoint joinPoint, Object returnValue){
        System.out.println("Logging after RETURNING MathService class methods "+ returnValue);
    }

    @AfterThrowing(value = "mathServiceClassPointcut()", throwing = "exception")
    public void loggingAfterMathClassError(JoinPoint joinPoint, RuntimeException exception){
        System.out.println("Logging after EXCEPTION MathService class methods "+ exception.getMessage());
    }

    @After(value = "mathServiceClassPointcut()")
    public void loggingAfterMathClass(JoinPoint joinPoint){
        System.out.println("Logging AFTER MathService class methods ");
    }
}
