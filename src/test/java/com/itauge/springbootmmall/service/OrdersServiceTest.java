package com.itauge.springbootmmall.service;

import com.itauge.springbootmmall.entity.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrdersServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void test(){
        Orders orders = new Orders();
        orders.setLoginName("123");
        orders.setUserId(1);
        orders.setUserAddress("1231");
        orders.setCost(100.0f);
        orderService.save(orders);
    }
}