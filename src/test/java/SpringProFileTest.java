import com.springtestlzc.config.MainConfigOfLifeCycle;
import com.springtestlzc.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class SpringProFileTest {
    //1)、使用命令行动态参数:在虚拟机参数位置(VMoptions)加载 -Dspring.profiles.active=test(见下图)
    @Test
    public void test1() {
        //创建ioc容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext();
        //1.创建一个applicationContext
        //2.设置需要的激活的环境
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("test", "dev");
        //3.注册配置类
        annotationConfigApplicationContext.register(MainConfigOfProfile.class);
        //4.刷新容器
        annotationConfigApplicationContext.refresh();
        String[] dataSources = annotationConfigApplicationContext.getBeanNamesForType(DataSource.class);
        for (String name : dataSources) {
            System.out.println(name);
        }
        annotationConfigApplicationContext.close();
    }


}
