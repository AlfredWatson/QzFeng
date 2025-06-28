package com.yzunlp.qzfeng.mapper;

import com.yzunlp.qzfeng.domain.po.UserHealth;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void save(UserHealth userHealth);
}
