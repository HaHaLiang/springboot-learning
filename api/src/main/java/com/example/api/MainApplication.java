package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // springboot 程序主入口,标注这是一个 springboot 应用
@ComponentScan(basePackages = "com.example.*")
public class MainApplication {

    public static void main(String[] args) {
        System.out.println("MainApplication start!");
    // 将springboot 应用启动,静态方法 run
        SpringApplication.run(MainApplication.class, args);
        System.out.println("MainApplication end!");
    }
}
