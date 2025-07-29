package com.yzunlp.qzfeng.service;

import com.yzunlp.qzfeng.domain.po.UserHealth;

/**
 * @author 10297
 * @since 2025/7/1 15:52
 */
public interface UserHealthService {

    void saveUserHealth(UserHealth userHealth);

    UserHealth getUserHealthById(Long userId);

}
