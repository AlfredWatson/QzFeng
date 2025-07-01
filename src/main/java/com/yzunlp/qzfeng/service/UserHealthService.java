package com.yzunlp.qzfeng.service;

import com.yzunlp.qzfeng.domain.po.UserHealth;

/**
 * @author 10297
 * @since 2025/7/1 15:52
 */
public interface UserHealthService {

    void addUserHealth(UserHealth userHealth);

    void updateUserHealth(UserHealth userHealth);

    UserHealth selectUserHealth(Long userId);
}
