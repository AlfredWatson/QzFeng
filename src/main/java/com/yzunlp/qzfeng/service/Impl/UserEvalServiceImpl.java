package com.yzunlp.qzfeng.service.Impl;

import com.yzunlp.qzfeng.common.BaseContext;
import com.yzunlp.qzfeng.domain.po.UserEval;
import com.yzunlp.qzfeng.mapper.UserEvalMapper;
import com.yzunlp.qzfeng.service.UserEvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author 10297
 * @since 2025/7/1 16:43
 */
@Service
public class UserEvalServiceImpl implements UserEvalService {

    @Autowired
    private UserEvalMapper userEvalMapper;

    @Override
    public void add(UserEval userEval) {
        userEval.setUserId(BaseContext.getCurrentId());
        if (userEval.getUpdateTime() == null) {
            userEval.setUpdateTime(LocalDateTime.now());
        }
        userEvalMapper.addUserEval(userEval);
    }

    @Override
    public void update(UserEval userEval) {
        userEval.setUpdateTime(LocalDateTime.now());
        userEvalMapper.updateUserEval(userEval);
    }

    @Override
    public UserEval getByUserId(Long userId) {
        return userEvalMapper.selectUserEval(userId);
    }
}
