package com.yzunlp.qzfeng.service.Impl;

import com.yzunlp.qzfeng.common.BaseContext;
import com.yzunlp.qzfeng.domain.po.Info2Health;
import com.yzunlp.qzfeng.domain.po.UserHealth;
import com.yzunlp.qzfeng.mapper.UserHealthMapper;
import com.yzunlp.qzfeng.service.UserHealthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 10297
 * @since 2025/7/1 22:06
 */
@Slf4j
@Service
public class UserHealthServiceImpl implements UserHealthService {

    private final UserHealthMapper userHealthMapper;

    @Autowired
    public UserHealthServiceImpl(UserHealthMapper userHealthMapper) {
        this.userHealthMapper = userHealthMapper;
    }

    /**
     * 保存用户健康信息（如果有就更新）
     * @param userHealth
     */
//    @Override
//    public void saveUserHealth(UserHealth userHealth) {
//        // 查寻是否存在
//        Info2Health info2Health = userHealthMapper.selectInfo2Health(BaseContext.getCurrentId());
//        // 如果不存在就插入
//        if (info2Health == null) {
//            // 保存用户健康信息
//            userHealthMapper.addUserHealth(userHealth);
//            info2Health = new Info2Health();
//            info2Health.setInfoId(BaseContext.getCurrentId());
//            info2Health.setHealthId(userHealth.getId());
//            // 保存“用户信息-用户健康信息”映射
//            userHealthMapper.addInfo2Health(info2Health);
//        } else {
//            // 如果存在就更新
//            userHealth.setId(info2Health.getHealthId());
//            userHealthMapper.updateUserHealth(userHealth);
//        }
//    }

    /**
     * 保存用户健康信息（带事务控制）
     */
//    @Transactional(rollbackFor = Exception.class) // 开启事务，并在异常时回滚
    public void saveUserHealth(UserHealth userHealth) {
        // 获取当前用户ID
        Long userId = BaseContext.getCurrentId();

        // 查询是否存在映射关系
        Info2Health info2Health = userHealthMapper.selectInfo2Health(userId);

        if (info2Health == null) {
            // 1. 插入健康信息
            userHealthMapper.addUserHealth(userHealth);

            // 2. 获取刚插入的健康信息ID（假设数据库主键自增，userHealth.getId() 可以拿到）
            Long healthId = userHealth.getId();
            if (healthId == null) {
                throw new RuntimeException("健康信息插入失败，无法获取ID");
            }

            // 3. 创建映射关系
            info2Health = new Info2Health();
            info2Health.setInfoId(userId);
            info2Health.setHealthId(healthId);

            // 4. 插入映射关系
            userHealthMapper.addInfo2Health(info2Health);
        } else {
            // 如果存在就更新
            userHealth.setId(info2Health.getHealthId());
            userHealthMapper.updateUserHealth(userHealth);
        }
    }

    @Override
    public UserHealth getUserHealthById(Long userId) {
        if (userId == null || userId <= 0) {
            userId = BaseContext.getCurrentId();
        }
        return userHealthMapper.selectUserHealthByUserId(userId);
    }
}
