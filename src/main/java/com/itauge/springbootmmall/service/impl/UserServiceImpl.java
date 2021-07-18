package com.itauge.springbootmmall.service.impl;

import com.itauge.springbootmmall.entity.User;
import com.itauge.springbootmmall.mapper.UserMapper;
import com.itauge.springbootmmall.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
