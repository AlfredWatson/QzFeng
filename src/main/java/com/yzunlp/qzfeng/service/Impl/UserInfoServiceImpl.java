package com.yzunlp.qzfeng.service.Impl;

import com.yzunlp.qzfeng.domain.dto.UserInfoDTO;
import com.yzunlp.qzfeng.service.UserInfoService;
import com.yzunlp.qzfeng.common.BaseContext;
import com.yzunlp.qzfeng.domain.dto.LoginDTO;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.po.*;
import com.yzunlp.qzfeng.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Huang
 * @description: TODO
 * @date: 2025/6/28 10:05
 */

@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo login(LoginDTO loginDTO) {
        // 检查手机号是否已存在
        UserInfo existingUser = userInfoMapper.selectByPhone(loginDTO.getPhone());
        if (existingUser != null) {
            return userInfoMapper.selectByPhoneAndPassword(loginDTO);
        } else {
            return null;
        }
    }

    @Override
    public void updateUserInfo(UserInfoDTO userInfoDTO) {
        userInfoDTO.setId(BaseContext.getCurrentId());
        userInfoMapper.updateUserInfo(userInfoDTO);
    }

    @Override
    public int register(RegisterDTO registerDTO) {
        // 检查手机号是否已存在
        UserInfo existingUser = userInfoMapper.selectByPhone(registerDTO.getPhone());
        if (existingUser != null) {
            // 用户已存在，注册失败
            return 0;
        } else {
            // 注册，插入用户数据
            return userInfoMapper.addUser(registerDTO);
        }
    }

    @Override
    public UserInfo selectById() {
        return userInfoMapper.selectById(BaseContext.getCurrentId());
    }
}
