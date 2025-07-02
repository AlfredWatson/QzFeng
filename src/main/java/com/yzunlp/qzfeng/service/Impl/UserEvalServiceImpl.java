package com.yzunlp.qzfeng.service.Impl;

import com.yzunlp.qzfeng.common.BaseContext;
import com.yzunlp.qzfeng.domain.po.UserEval;
import com.yzunlp.qzfeng.mapper.UserEvalMapper;
import com.yzunlp.qzfeng.service.UserEvalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author 10297
 * @since 2025/7/1 16:43
 */
@Slf4j
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
        if (userId == null || userId <= 0) {
            userId = BaseContext.getCurrentId();
        }
        log.info("service: 查询用户对蜂胶的评价信息(user-id={})", userId);
        return userEvalMapper.selectUserEval(userId);
    }
}
