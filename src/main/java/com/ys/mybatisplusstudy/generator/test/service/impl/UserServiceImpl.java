package com.ys.mybatisplusstudy.generator.test.service.impl;

import com.ys.mybatisplusstudy.generator.test.entity.User;
import com.ys.mybatisplusstudy.generator.test.mapper.UserMapper;
import com.ys.mybatisplusstudy.generator.test.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author IT可乐
 * @since 2020-07-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
