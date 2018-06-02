package com.cheney.satisfy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cheney.satisfy.dao")
public class SatisfyApp {

    public static void main(String[] args) {
        SpringApplication.run(SatisfyApp.class, args);
    }
}
