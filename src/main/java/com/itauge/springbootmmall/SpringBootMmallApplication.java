package com.itauge.springbootmmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.itauge.springbootmmall.mapper")
//@ComponentScan("com.itauge.springbootmmall.filter")
public class SpringBootMmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMmallApplication.class, args);
    }

}
