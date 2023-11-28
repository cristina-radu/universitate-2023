import aspect.MyLoggingAspect;
import config.MyApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.MathService;

public class MyApplication {

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MyApplicationContext.class, MyLoggingAspect.class);
        MathService mathService = applicationContext.getBean(MathService.class);
        mathService.sum(2, 3);
    }
}
