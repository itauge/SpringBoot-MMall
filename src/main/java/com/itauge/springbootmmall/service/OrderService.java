package com.itauge.springbootmmall.service;

import com.itauge.springbootmmall.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itauge.springbootmmall.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author itauge
 * @since 2021-07-13
 */
public interface OrderService extends IService<Orders> {
    public boolean save(Orders orders, User user,String address,
                        String remark);
}
