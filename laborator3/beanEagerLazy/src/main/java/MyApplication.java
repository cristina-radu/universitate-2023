import config.MyApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MyApplicationContext.class);
    }
}
