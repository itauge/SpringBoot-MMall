package com.itauge.springbootmmall.service;

import com.itauge.springbootmmall.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itauge.springbootmmall.vo.ProductCategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author itauge
 * @since 2021-07-13
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    public List<ProductCategoryVO> getAllProductCategoryVO();

}
