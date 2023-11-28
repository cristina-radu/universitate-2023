import config.MyApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.MathService;

public class MyApplication {

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MyApplicationContext.class);
        MathService mathServiceOne = applicationContext.getBean(MathService.class);
        MathService mathServiceTwo = applicationContext.getBean(MathService.class);
        MathService mathServiceThree = applicationContext.getBean(MathService.class);
    }
}
