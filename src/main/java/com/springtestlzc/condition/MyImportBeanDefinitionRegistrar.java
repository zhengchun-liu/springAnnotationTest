package com.springtestlzc.condition;

import com.springtestlzc.beans.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     *  AnnotationMetadata : 当前类注解信息
     *  BeanDefinitionRegistry : BeanDefinition注册类（Bean定义注册类）
     *                      把所有要添加到容器中的Bean：调用
     *                      BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        //判断BeanDefinition注册类中是否有id为一下的 类
//        Boolean flag1 = registry.containsBeanDefinition("red");
//        Boolean flag2 = registry.containsBeanDefinition("blue");
        //判断BeanDefinition注册类中是否有id为一下的 类
        Boolean flag1 = registry.containsBeanDefinition("com.springtestlzc.beans.Red");
        Boolean flag2 = registry.containsBeanDefinition("com.springtestlzc.beans.Blue");
        //指定Bean的定义信息（Bean的类型，Bean的作用域、、、）
        BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
        //注册一个bean，指定bean名
        if (flag1 && flag2) {
            registry.registerBeanDefinition("rainBow", beanDefinition);
        }
    }
}
