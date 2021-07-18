package com.itauge.springbootmmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itauge.springbootmmall.entity.*;
import com.itauge.springbootmmall.mapper.CartMapper;
import com.itauge.springbootmmall.mapper.OrderDetailMapper;
import com.itauge.springbootmmall.mapper.OrderMapper;
import com.itauge.springbootmmall.mapper.UserAddressMapper;
import com.itauge.springbootmmall.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author itauge
 * @since 2021-07-13
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public boolean save(Orders orders, User user, String address,
                        String remark) {
        //判斷是新地址還是舊地址
        if (orders.getUserAddress().equals("newAddress")){
            //存入數據庫
            UserAddress userAddress = new UserAddress();
            userAddress.setAddress(address);
            userAddress.setRemark(remark);
            userAddress.setIsdefault(1);
            userAddress.setUserId(user.getId());

            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("isdefault",1);
            wrapper.eq("user_id",user.getId());

            UserAddress oldDefault = userAddressMapper.selectOne(wrapper);

            oldDefault.setIsdefault(0);
            userAddressMapper.updateById(oldDefault);
            userAddressMapper.insert(userAddress);
            orders.setUserAddress(address);


        }
        //存儲orders
        orders.setUserId(user.getId());
        orders.setLoginName(user.getLoginName());

        String seriaNumber = null;
        try {
            StringBuffer result = new StringBuffer();
            for(int i=0;i<32;i++) {
                result.append(Integer.toHexString(new Random().nextInt(16)));
            }
            seriaNumber =  result.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        orders.setSerialnumber(seriaNumber);

        orderMapper.insert(orders);

        //存儲ordersdetail
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",user.getId());
        List<Cart> cartList = cartMapper.selectList(wrapper);
        for (Cart cart : cartList) {
            OrderDetail orderDetail = new OrderDetail();
            BeanUtils.copyProperties(cart,orderDetail);
            orderDetail.setId(null);
            orderDetail.setOrderId(orders.getId());
            orderDetailMapper.insert(orderDetail);
        }

        //清空購物車
        wrapper = new QueryWrapper();
        wrapper.eq("user_id",user.getId());
        cartMapper.delete(wrapper);

        return true;
    }

}
