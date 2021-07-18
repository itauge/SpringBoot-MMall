package com.itauge.springbootmmall.service.impl;

import com.itauge.springbootmmall.entity.UserAddress;
import com.itauge.springbootmmall.mapper.UserAddressMapper;
import com.itauge.springbootmmall.service.UserAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author itauge
 * @since 2021-07-13
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

}
