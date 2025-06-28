package com.yzunlp.qzfeng.Service.Impl;

import com.yzunlp.qzfeng.Service.UserService;
import com.yzunlp.qzfeng.domain.po.UserHealth;
import com.yzunlp.qzfeng.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Huang
 * @description: TODO
 * @date: 2025/6/28 10:05
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void save(UserHealth userHealth) {
        userMapper.save(userHealth);
    }
}
