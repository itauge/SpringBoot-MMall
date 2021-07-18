package com.itauge.springbootmmall.service;

import com.itauge.springbootmmall.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author itauge
 * @since 2021-07-13
 */
public interface ProductService extends IService<Product> {
    public List<Product> findByCategoryId(Integer categoryId,String type);
}
