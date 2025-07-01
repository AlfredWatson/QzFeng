package com.yzunlp.qzfeng.mapper;

import com.yzunlp.qzfeng.domain.po.UserHealth;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 10297
 * @since 2025/7/1 16:03
 */
@Mapper
public interface UserHealthMapper {
    /**
     * 添加用户健康信息
     *
     * @param userHealth 用户健康信息
     */
    void addUserHealth(UserHealth userHealth);

    /**
     * 修改用户健康信息
     *
     * @param userHealth 用户健康信息
     */
    void updateUserHealth(UserHealth userHealth);

    /**
     * 查询用户健康信息
     *
     * @param userId 用户ID
     * @return 用户健康信息
     */
    UserHealth selectUserHealth(Long userId);
}
