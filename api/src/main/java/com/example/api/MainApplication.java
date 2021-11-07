package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
// springboot 程序主入口
public class MainApplication {

    public static void main(String[] args) {
        System.out.println("MainApplication start!");
        SpringApplication.run(MainApplication.class, args);
        System.out.println("MainApplication end!");
    }

}
