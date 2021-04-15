import com.springtestlzc.beans.Person;
import com.springtestlzc.config.MainConfig;
import com.springtestlzc.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class SpringTest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext(MainConfig2.class);

    @SuppressWarnings("resource")
    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        String[] strs = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name : strs) {
            System.out.println(name);
        }
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfig2.class);
//        System.out.println("创建了ioc容器");
//        String[] strs = annotationConfigApplicationContext.getBeanDefinitionNames();
//        Object bean = annotationConfigApplicationContext.getBean("person");
//        Object bean2 = annotationConfigApplicationContext.getBean("person");
        String[] beans = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name : beans) {
            System.out.println(name);
        }
    }

    @Test
    public void test3() {
        Environment environment = annotationConfigApplicationContext.getEnvironment();
        System.out.println(environment.getProperty("os.name"));
        String[] beans = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String name : beans) {
            System.out.println(name);
        }
    }
}
