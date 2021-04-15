package com.springtestlzc.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat construct...创建");
    }

    public void destroy() throws Exception {
        System.out.println("cat destroy...销毁");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesSet...初始化");
    }
}
