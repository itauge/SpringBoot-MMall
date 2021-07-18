package com.itauge.springbootmmall.service.impl;

import com.itauge.springbootmmall.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService service;

    @Test
    void test(){
        System.out.println(service.getById(733));
    }
}