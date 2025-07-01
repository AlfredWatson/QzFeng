package com.yzunlp.qzfeng.Service.Impl;

import com.yzunlp.qzfeng.Service.UserService;
import com.yzunlp.qzfeng.common.BaseContext;
import com.yzunlp.qzfeng.domain.dto.LoginDTO;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.po.*;
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
        //插入数据
        userMapper.saveHealthStatus(userHealth);
        Long healthId = userHealth.getId();
        Long infoId = BaseContext.getCurrentId();
        userMapper.save2info2health(healthId,infoId);
    }

    @Override
    public void savePropolisUsage(UserPropolis userPropolis) {
        userMapper.savePropolisUsage(userPropolis);
    }

    @Override
    public UserInfo login(LoginDTO loginDTO) {
//        UserInfo userInfo = userMapper.login(loginDTO);
        // 检查手机号是否已存在
        UserInfo existingUser = userMapper.selectByPhone(loginDTO.getPhone());
        if (existingUser != null){
            return userMapper.selectByPhoneAndPassword(loginDTO);
        } else {
            return null;
        }
    }

    @Override
    public int register(RegisterDTO registerDTO) {
        // 检查手机号是否已存在
        UserInfo existingUser = userMapper.selectByPhone(registerDTO.getPhone());
        if (existingUser != null) {
            // 用户已存在，注册失败
            return 0;
        } else {
            // 注册，插入用户数据
            return userMapper.addUser(registerDTO);
        }
    }

    @Override
    public void saveEvaluation(UserEval userEval) {
        userMapper.saveEvaluation(userEval);
    }

    @Override
    public void saveCheckUp(UserCheckupForm userCheckupForm) {
        userMapper.saveCheckUp(userCheckupForm);
    }
}
