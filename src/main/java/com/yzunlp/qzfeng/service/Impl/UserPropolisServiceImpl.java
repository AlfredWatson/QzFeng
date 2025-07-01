package com.yzunlp.qzfeng.service.Impl;

import com.yzunlp.qzfeng.common.BaseContext;
import com.yzunlp.qzfeng.domain.po.UserPropolis;
import com.yzunlp.qzfeng.mapper.UserPropolisMapper;
import com.yzunlp.qzfeng.service.UserPropolisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author 10297
 * @since 2025/7/1 16:42
 */
@Slf4j
@Service
public class UserPropolisServiceImpl implements UserPropolisService {

    @Autowired
    private UserPropolisMapper userPropolisMapper;

    @Override
    public void add(UserPropolis userPropolis) {
        // 从上下文(ThreadLocal)获取用户ID
        userPropolis.setUserId(BaseContext.getCurrentId());
        log.info("用户ID: {}", userPropolis.getUserId());
        // 设置默认更新时间
        if (userPropolis.getUpdateTime() == null) {
            userPropolis.setUpdateTime(LocalDateTime.now());
        }
        userPropolisMapper.addUserPropolis(userPropolis);
    }

    @Override
    public void update(UserPropolis userPropolis) {
        // 自动更新时间
        userPropolis.setUpdateTime(LocalDateTime.now());
        userPropolisMapper.updateUserPropolis(userPropolis);
    }

    @Override
    public UserPropolis getByUserId(Long userId) {
        return userPropolisMapper.selectUserPropolis(userId);
    }
}
