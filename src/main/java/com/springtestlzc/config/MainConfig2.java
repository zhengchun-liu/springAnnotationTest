package com.springtestlzc.config;

import com.springtestlzc.beans.Color;
import com.springtestlzc.beans.Person;
import com.springtestlzc.beans.Red;
import com.springtestlzc.condition.ColorFactoryBean;
import com.springtestlzc.condition.LinuxCondition;
import com.springtestlzc.condition.MyImportBeanDefinitionRegistrar;
import com.springtestlzc.condition.MyImportSelector;
import com.springtestlzc.condition.WinCondition;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//快速导入组件bean的id名默认为全类名
public class MainConfig2 {
    //* @see ConfigurableBeanFactory#SCOPE_PROTOTYPE prototupe
    //* @see ConfigurableBeanFactory#SCOPE_SINGLETON singleton
    //* @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
    //* @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
    //@Scope
    //@Lazy
    @Bean("person")
    public Person person() {
        System.out.println("创建bean中...");
        return new Person("25","gdx");
    }

    /**
     * @Conditional({Condition}) 按照一定条件进行判断，满足容器中条件注册bean
     * @return
     */
    @Conditional(value = {WinCondition.class})
    @Bean("bill")
    public Person person01() {
        return new Person("60","bill");
    }
    @Conditional(value = {LinuxCondition.class})
    @Bean("linus")
    public Person person02() {
        return new Person("62","linus");
    }

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
