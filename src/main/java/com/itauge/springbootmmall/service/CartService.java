package com.itauge.springbootmmall.service;

import com.itauge.springbootmmall.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itauge.springbootmmall.vo.CartVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author itauge
 * @since 2021-07-13
 */
public interface CartService extends IService<Cart> {
    public List<CartVO> findAllCartVOByUserId(Integer id);

}
