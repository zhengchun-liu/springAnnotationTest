package com.springtestlzc.condition;

import com.springtestlzc.beans.Color;
import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean {

    //返回一个 对象 这个对象会存在容器中
    public Object getObject() throws Exception {
        return new Color();
    }

    //设置bean的类型
    public Class<?> getObjectType() {
        return Color.class;
    }

    //控制返回是不是单例true/false
    //true只会创建一个Bean放在工厂中
    //false每次调用会创建一个bean
    public boolean isSingleton() {
        return true;
    }
}
