package com.springtestlzc.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class TxConfig {

    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("test");
        dataSource.setPassword("123456");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        //Spring对@Configuration有特殊处理；给容器中加组件的方法，多次调用只是从容器中取；
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //注册事务管理器在容器中
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }
}
