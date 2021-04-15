import com.springtestlzc.beans.Car;
import com.springtestlzc.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringLifeCycleTest {

    @Test
    public void test1() {
        //创建ioc容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        //Car car = annotationConfigApplicationContext.getBean(Car.class);
        System.out.println("容器创建完成。。。");
        annotationConfigApplicationContext.close();
    }
}
