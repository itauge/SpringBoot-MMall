package com.itauge.springbootmmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itauge.springbootmmall.mapper")
public class SpringBootMmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMmallApplication.class, args);
    }

}
