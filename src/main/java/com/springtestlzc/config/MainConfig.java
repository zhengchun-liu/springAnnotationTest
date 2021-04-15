package com.springtestlzc.config;

import com.springtestlzc.beans.Person;
import com.springtestlzc.controllers.BookController;
import com.springtestlzc.services.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
//配置类==配置文件
@Configuration//告诉spring这是一个配置类
//@ComponentScan(value = "com.springtestlzc" , excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//})
//@ComponentScan(value = "com.springtestlzc" , includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//}, useDefaultFilters = false)
@ComponentScans(value = {
        @ComponentScan(value = "com.springtestlzc" , includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        }, useDefaultFilters = false)
})
public class MainConfig {
    @Bean
    public Person person() {
        return new Person("12", "ll");
    }
}
