import com.springtestlzc.beans.Person;
import com.springtestlzc.beans.RainBow;
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

    @Test
    public void testImport() {
        printScanBeans(annotationConfigApplicationContext);
        System.out.println(annotationConfigApplicationContext.getBean(RainBow.class));
        Object bean1 = annotationConfigApplicationContext.getBean("colorFactoryBean");
        Object bean2 = annotationConfigApplicationContext.getBean("colorFactoryBean");
        System.out.println(bean1 == bean2);//返回的是colorFactoryBean中是单实例所以返回true
        System.out.println(bean1.getClass());//返回的是colorFactoryBean.getObject()方法生成的Bean
        Object bean3 = annotationConfigApplicationContext.getBean("&colorFactoryBean");
        System.out.println(bean3.getClass());//返回的是colorFactoryBean本身
    }

    private void printScanBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        String[] beans = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name : beans) {
            System.out.println(name);
        }
    }
}
