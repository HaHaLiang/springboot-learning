package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // springboot 程序主入口,标注这是一个 springboot 应用
@ComponentScan(basePackages = "com.example.*")
//@EnableJpaRepositories(basePackages = {
//        "com.example.repository"
//})
@EnableJpaRepositories("com.example.repository")
@EntityScan(basePackages = {"com.example.entity"})
@PropertySource("classpath:application.yaml")

public class MainApplication {

    public static void main(String[] args) {
        System.out.println("MainApplication start!");
    // 将springboot 应用启动,静态方法 run
        SpringApplication.run(MainApplication.class, args);
        System.out.println("MainApplication end!");
    }
}
