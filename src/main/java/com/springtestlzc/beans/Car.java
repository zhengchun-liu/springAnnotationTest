package com.springtestlzc.beans;

public class Car {

    public Car() {
        System.out.println("car construct...创建");
    }

    public void init() {
        System.out.println("car init...初始化");
    }

    public void destroy() {
        System.out.println("car destroy...销毁");
    }
}
