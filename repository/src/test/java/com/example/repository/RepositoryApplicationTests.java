package com.example.repository;

import org.junit.jupiter.api.Test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.sql.DataSource;

//@SpringBootTest(classes = RepositoryApplication.class)
@ComponentScan(basePackages = "com.example.*")
class RepositoryApplicationTests {
    @Resource
    DataSource dataSource;

    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());
    }
}
