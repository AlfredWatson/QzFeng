package com.yzunlp.qzfeng.service.Impl;

import com.yzunlp.qzfeng.domain.po.UserCheckupForm;
import com.yzunlp.qzfeng.mapper.UserCheckupFormMapper;
import com.yzunlp.qzfeng.service.UserCheckupFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author 10297
 * @since 2025/7/1 16:44
 */
@Service
public class UserCheckupFormServiceImpl implements UserCheckupFormService {

    @Autowired
    private UserCheckupFormMapper checkupFormMapper;

    @Override
    public void add(UserCheckupForm checkupForm) {
        if (checkupForm.getUpdateTime() == null) {
            checkupForm.setUpdateTime(LocalDateTime.now());
        }
        checkupFormMapper.addUserCheckupForm(checkupForm);
    }

    @Override
    public void update(UserCheckupForm checkupForm) {
        checkupForm.setUpdateTime(LocalDateTime.now());
        checkupFormMapper.updateUserCheckupForm(checkupForm);
    }

    @Override
    public UserCheckupForm getByUserId(Long userId) {
        return checkupFormMapper.selectUserCheckupForm(userId);
    }
}
