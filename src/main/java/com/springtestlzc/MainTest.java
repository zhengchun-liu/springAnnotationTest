package com.springtestlzc;

import com.springtestlzc.beans.Person;
import com.springtestlzc.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person p = (Person) applicationContext.getBean("person");
//        System.out.println(p);
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) annotationConfigApplicationContext.getBean(Person.class);
        //annotationConfigApplicationContext.getBeanDefinitionNames()
        System.out.println(person);

        String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
