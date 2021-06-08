import com.springtestlzc.aop.MathCalculator;
import com.springtestlzc.config.MainConfigOfAop;
import com.springtestlzc.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopTest {

    @Test
    public void test1() {
        //创建ioc容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        MathCalculator mathCalculator = annotationConfigApplicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1,1);
        annotationConfigApplicationContext.close();
    }
}
