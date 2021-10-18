package com.zhiku.elearning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zhiku.elearning.mapper")
@SpringBootApplication
public class ElearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElearningApplication.class, args);
    }

}
