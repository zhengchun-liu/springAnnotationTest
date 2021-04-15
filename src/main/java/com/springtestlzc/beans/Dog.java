package com.springtestlzc.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {
    public Dog() {
        System.out.println("dog construct...创建");
    }

    @PostConstruct
    public void init() {
        System.out.println("dog init...PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("dog destroy...@PreDestroy");
    }
}
