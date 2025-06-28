package com.yzunlp.qzfeng.Service.Impl;

import com.yzunlp.qzfeng.Service.UserService;
import com.yzunlp.qzfeng.domain.dto.LoginDTO;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.po.UserHealth;
import com.yzunlp.qzfeng.domain.po.UserInfo;
import com.yzunlp.qzfeng.domain.po.UserPropolis;
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
    public void saveHealthStatus(UserHealth userHealth) {
        userMapper.saveHealthStatus(userHealth);
    }

    @Override
    public void savePropolisUsage(UserPropolis userPropolis) {
        userMapper.savePropolisUsage(userPropolis);
    }

    @Override
    public UserInfo login(LoginDTO loginDTO) {
        UserInfo userInfo = userMapper.login(loginDTO);
        return userInfo;
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        userMapper.register(registerDTO);
    }
}
