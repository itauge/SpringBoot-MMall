package com.itauge.springbootmmall.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserAddressServiceTest {

    @Autowired
    private UserAddressService userAddressService;

    @Test
    void test() {
//        Map<String,Object> map = new HashMap<>();
//        map.put("user_id",10);
//        userAddressService.listByMap(map).forEach(System.out::println);
//    }

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id", 27);
        userAddressService.list(wrapper);
    }
}